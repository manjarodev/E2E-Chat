package com.devbeans.io.chat.fragments

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.devbeans.io.chat.BuildConfig
import com.devbeans.io.chat.R
import com.devbeans.io.chat.activities.*
import com.devbeans.io.chat.adapters.SettingsAdapter
import com.devbeans.io.chat.app.AppSession
import com.devbeans.io.chat.callBacks.OnSettingsClick
import com.devbeans.io.chat.databinding.CustomNicknameDailogBinding
import com.devbeans.io.chat.databinding.FragmentProfileManageBinding
import com.devbeans.io.chat.models.SettingsModel
import com.devbeans.io.chat.models.User
import com.devbeans.io.chat.network.ApiHelper
import com.devbeans.io.chat.network.OnNetworkResponse
import com.devbeans.io.chat.network.serializers.requestbody.UpdateProfileRequest
import com.devbeans.io.chat.network.serializers.response.BaseResponse
import com.devbeans.io.chat.network.serializers.response.GetProfileResponse
import com.devbeans.io.chat.network.serializers.response.UploadMediaResponse
import com.devbeans.io.chat.utils.*
import com.devbeans.io.chat.utils.logging.Log
import com.devbeans.io.chat.viewmodels.SettingsViewModel
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.text.ParseException
import java.util.*


class ProfileManageFragment
    : Fragment(), OnNetworkResponse,
    OnSettingsClick {
    var mBinding: FragmentProfileManageBinding? = null
    private var mCreateDialogBinding: CustomNicknameDailogBinding? = null
    private var mCreateDialog: AlertDialog? = null
    private var mUser: User? = null
    private val mutableLiveUser = MutableLiveData<User>()
    private val img_file: File? = null
    private var mViewModel: SettingsViewModel? = null
    private var adapter: SettingsAdapter? = null
    private val observer: Observer<List<SettingsModel?>?> =
        Observer<List<SettingsModel?>?> { settingsModels -> adapter!!.setSettingsList(settingsModels) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    private fun showProfileData() {
        mUser = AppSession.getUser()
        if (!TextUtils.isEmpty(mUser!!.chatUserId)) mBinding!!.tvUserId.text =
            mUser!!.chatUserId
        if (TextUtils.isEmpty(mUser!!.chatNickName!!.trim { it <= ' ' })) {
            mBinding!!.tvNickname.alpha = 0.6f
            mBinding!!.tvNickname.text = "Nick Name"
        } else {
            mBinding!!.tvNickname.alpha = 1f
            mBinding!!.tvNickname.text = mUser!!.chatNickName
        }

        if (mUser!!.profileImageLink != null) {
            mBinding!!.ivCamera.visibility = View.GONE
            Glide.with(requireActivity())
                .load(if (mUser!!.profileImageLink != null) mUser!!.profileImageLink else R.drawable.ic_unknown)
                .into(
                    mBinding!!.ivCircularProfileNew
                )
        } else {
            mBinding!!.ivCamera.visibility = View.VISIBLE
        }
        Log.d(
            "TAG",
            "showProfileData: " + mUser!!.chatUserId + " Nickname: " + mUser!!.chatNickName + "Profile Image: " + mUser!!.profileImage
        )
    }


    private fun getProfileDataFromApi(
        chatUserId: String,
        fromUpdate: Boolean
    ) {
        ApiHelper.with()?.profileData(chatUserId, chatUserId, this)

        Log.d(
            ContentValues.TAG,
            "Profile_Fragment_Management getProfileDataFromApi: " + Constants.END_POINT + RequestCodes.API_END_POINTS.GET_PROFILE +
                    " Requset: " + "chatUserid= " + chatUserId + " " + "profile id" + chatUserId
        )
    }


    private fun updateProfileImage(file: File) {
        ApiHelper.with()?.updateProfileImage(file, this, requireActivity())
        Log.d(
            ContentValues.TAG,
            "Profile_Fragment_Management updateProfileImage: " + Constants.END_POINT + RequestCodes.API_END_POINTS.GET_PROFILE +
                    " Requset: " + "userChatId= " + AppSession.getUser().chatUserId + " " + " media" + file.toString()
        )
    }

    private fun checkIsSocketConnected(): Boolean {
        return MainActivity.isSocketConnected.value != null && MainActivity.isSocketConnected.value!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentProfileManageBinding.inflate(inflater, container, false)
        listeners()
        mViewModel = SettingsViewModel.with(requireActivity())
        adapter = SettingsAdapter(requireActivity(), this)
        mBinding!!.settingsRecycler.adapter = adapter
        mBinding!!.settingsRecycler.setHasFixedSize(true)
        mBinding?.tvVersion?.text =
            String.format(Locale.getDefault(), "%s", "Version: ${BuildConfig.VERSION_NAME}")
        if (AppSession.getUser() != null) showProfileData()


        return mBinding!!.root
    }


    @SuppressLint("CheckResult")
    private fun observers() {
        mutableLiveUser.observe(requireActivity()) { user: User? ->
            if (user != null) {
                if (!TextUtils.isEmpty(user.chatUserId)) mBinding!!.tvUserId.text = user.chatUserId
                if (!TextUtils.isEmpty(user.chatNickName)) mBinding!!.tvNickname.text =
                    user.chatNickName
                if (!TextUtils.isEmpty(user.profileImage)) {

                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        dummyInfo()
        mViewModel!!.settingsLiveData.observe(requireActivity(), observer)
    }

    override fun onStop() {
        mViewModel!!.settingsLiveData.removeObserver(observer)
        super.onStop()
    }

    private fun dummyInfo() {
        if (Constants.URI != null) {

            if (!TextUtils.isEmpty(Constants.NICK_NAME!!.trim { it <= ' ' })) {

//                mBinding.tvUsername.setText(Constants.NICK_NAME);
            }
        }
    }


    private fun listeners() {
        mBinding!!.layoutNotificationSettings.setOnClickListener { view: View? ->
            val intent = Intent(requireActivity(), NotificationActivity::class.java)
            startActivity(intent)
        }
        mBinding!!.ivEdit.setOnClickListener { view: View? ->
//                startActivity(new Intent(requireActivity(), EditProfileActivity.class));
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }
            try {
                showQRDialog(
                    generateQrCode(AppSession.getUser().chatUserId),
                    AppSession.getUser().chatUserId!!
                )
            } catch (e: WriterException) {
                e.printStackTrace()
            }
        }
        mBinding!!.ivEditNew.setOnClickListener { view: View? -> showChangeNickNameDialog() }
        mBinding!!.ivCircularProfileNew.setOnClickListener { view: View? ->
            if (Utills.isSubscriptionExpired()) {
                Utills.showSubscriptionEnd()
                return@setOnClickListener
            }

            ImagePicker.with(this@ProfileManageFragment)
                .galleryOnly()
                .start()
        }
        mBinding!!.layoutBlockedContacts.setOnClickListener {

        }
        mBinding!!.layoutAutoLockSettings.setOnClickListener {
            startActivity(
                Intent(
                    requireActivity(),
                    AutoLockSettingActivity::class.java
                )
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        assert(data != null)
        if (data!!.data != null) {
            val extension = AndroidUtil.getMimeType(requireActivity(), data.data)
            val uri = data.data
            var path: String? = ""
            when (extension) {
                "png", "jpg", "jpeg" -> {

//                    path = FilePath.getPath(requireActivity(), uri);
                    path = PathUtil.getPath(requireActivity(), uri, Build.VERSION.SDK_INT, true)
                    val file = File(path)
                    if (file.exists()) {
//                        uploadFile(file);
                        updateProfileImage(file)
                        mUser!!.profileImageLink = file.toString()
                        AppSession.saveUser(mUser)
                        showProfileData()
                    }
                }
            }
        }
    }

    private fun uploadFile(file: File) {
        Log.d(
            ContentValues.TAG,
            "Profile_Fragment_Management uploadFile: " + Constants.END_POINT + RequestCodes.API_END_POINTS.UPLOAD_MEDIA_ONLY +
                    " Request: " +
                    "media= " + file.toString()
        )
    }

    private fun showQRDialog(bitmap: Bitmap, chatUserId: String) {
        val alertCustomdialog =
            LayoutInflater.from(requireActivity()).inflate(R.layout.qr_code_dialog, null)
        val alert = AlertDialog.Builder(requireActivity())
        alert.setView(alertCustomdialog.rootView)
        mCreateDialog = alert.create()
        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        mCreateDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //finally show the dialog box in android all
        mCreateDialog!!.show()

        val textView = alertCustomdialog.findViewById<TextView>(R.id.qr_text)
        val imageView = alertCustomdialog.findViewById<ImageView>(R.id.qr_image)
        imageView.setImageBitmap(bitmap)
        textView.text = chatUserId
    }

    private fun showChangeNickNameDialog() {
        val alertCustomdialog =
            LayoutInflater.from(requireActivity()).inflate(R.layout.custom_nickname_dailog, null)
        //initialize alert builder
        mCreateDialogBinding = CustomNicknameDailogBinding.bind(alertCustomdialog)
        val alert = AlertDialog.Builder(requireActivity())
        //set our custom alert dialog to tha alertdialog builder
        alert.setView(mCreateDialogBinding!!.root)
        mCreateDialog = alert.create()
        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        mCreateDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //finally show the dialog box in android all
        mCreateDialog!!.show()
        mCreateDialogBinding!!.btnCreate.setOnClickListener { view: View? ->
            if (!TextUtils.isEmpty(
                    mCreateDialogBinding!!.etNickname.text.toString().trim { it <= ' ' })
            ) {
//                updateProfile(mCreateDialogBinding.etNickname.getText().toString(), "");
                updateNickName(mCreateDialogBinding!!.etNickname.text.toString())
                mCreateDialog!!.dismiss()
            }
        }
        mCreateDialogBinding!!.btnCancel.setOnClickListener { view: View? -> mCreateDialog!!.dismiss() }
    }

    private fun updateNickName(toString: String) {
        val request = UpdateProfileRequest()
        request.nickName = toString
        Log.d(
            ContentValues.TAG,
            "Profile_Fragment_Management updateNickName: " + Constants.END_POINT + RequestCodes.API_END_POINTS.UPDATE_PROFILE +
                    " Request: " +
                    "chat_user_id= " + mUser!!.chatUserId + " profile Request" + request.toString()
        )

        ApiHelper.with()
            ?.updateNickName(mUser!!.chatUserId, request, this, requireActivity())
//        NetworkCall.make()
//            .setCallback(this)
//            .setTag(RequestCodes.API.UPDATE_PROFILE)
//            .autoLoadingCancel(getLoading(requireActivity(), "Uploading..."))
//            .enque(
//                Network.apis().updateProfile(
//                    mUser!!.chatUserId, request
//                )
//            )
//            .execute()
        mUser!!.chatNickName = toString
        AppSession.saveUser(mUser)
        showProfileData()
    }

    //************************************************************
    @Throws(ParseException::class)
    override fun onSuccess(
        call: Call<*>?, response: Response<*>,
        tag: Any
    ) //************************************************************
    {
        if (tag as Int == RequestCodes.API.GET_PROFILE) {
            if (response.code() == 200) {
                val res = response.body() as GetProfileResponse?
                handleGetProfile(res)
            }
        }
        if (tag == RequestCodes.API.UPLOAD_MEDIA_ONLY) {
            if (response.code() == 200) {
                val res = response.body() as UploadMediaResponse?
                handleUploadMediaResponse(res)
            }
        }
        if (tag == RequestCodes.API.UPDATE_PROFILE) {
            if (response.code() == 200) {
                val res = response.body() as GetProfileResponse?
                res?.let {
                    Log.d(
                        ContentValues.TAG,
                        "Profile_Fragment_Management updateProfile: " + Constants.END_POINT + RequestCodes.API_END_POINTS.UPDATE_PROFILE +
                                Constants.RESPONSE +
                                res.toString()
                    )
                    //                    getProfileDataFromApi(mUser.getChatUserId(), true);
                }
            }
        }
        if (tag == RequestCodes.API.UPDATE_PROFILE_IMAGE) {
            if (response.code() == 200) {
                val res = response.body() as GetProfileResponse?
                res?.let {
                    res.profileImageBucketLink?.let {
                        Log.d(
                            ContentValues.TAG,
                            "Profile_Fragment_Management updateProfileImage: " + Constants.END_POINT + RequestCodes.API_END_POINTS.UPDATE_PROFILE_IMAGE +
                                    Constants.RESPONSE +
                                    res.toString()
                        )
                        //                    getProfileDataFromApi(mUser.getChatUserId(), true);
                    }
                }
            }
        }
    }

    private fun handleUploadMediaResponse(res: UploadMediaResponse?) {
        if (res != null && res.status.equals("Success", ignoreCase = true)) {
            if (!TextUtils.isEmpty(res.media)) {
                Log.d(
                    ContentValues.TAG,
                    "Profile_Fragment_Management uploadMedia: " + Constants.END_POINT + RequestCodes.API_END_POINTS.UPLOAD_MEDIA_ONLY +
                            Constants.RESPONSE +
                            res.toString()
                )
                Log.d("TAG", "onSuccess: " + res.media)
                val nickName = ""
                //                        updateProfile(nickName, res.getMedia());
            }
        }
    }

    private fun handleGetProfile(res: GetProfileResponse?) {
        if (res != null && res.user != null) {
            Log.d(
                ContentValues.TAG,
                "Profile_Fragment_Management getProfileDataFromApi: " + Constants.END_POINT + RequestCodes.API_END_POINTS.GET_PROFILE +
                        Constants.RESPONSE +
                        res.toString()
            )
            var img_link: String? = null
            if (mUser != null && mUser!!.profileImageLink != null) img_link =
                mUser!!.profileImageLink
            mUser = User()
            mUser = res.user
            mUser!!.profileImageLink = img_link
            //                    if (res.getProfileImageBucketLink() != null) {
//                        img_file = new File(MainApp.Companion.getAppContext().getFilesDir().getPath() + res.getUser().getProfileImage());
//                        DownloaderImage.getInstance().download(img_file.getAbsolutePath(), res.getProfileImageBucketLink());
////                            DownloaderImage.getInstance().downloadImage(res.getConversation().getPhoto(),res.getImageBucketLink(),MainApp.Companion.getAppContext().getFilesDir().getPath(),res.getConversation().getConversationId());
//                        DownloaderImage.getInstance().fileImageMutableLiveData.observe((LifecycleOwner) getViewLifecycleOwner(), file1 -> {
//                                    if (file1 != null) {
//                                        if (img_file != null) {
//                                            if (img_file.getAbsolutePath().equalsIgnoreCase(file1.getAbsolutePath())) {
//                                                mUser.setProfileImageLink(file1.getPath());
//                                                AppSession.saveUser(mUser);
//                                                showProfileData();
////                                                MainApp.database.conversationsDao().updateFilePath(res.getConversation().getConversationId(), file1.getPath());
//
////                                                ChatActivity.Companion.getAdapter().notifyItemChanged(getAdapterPosition());
//                                            }
//                                        }
//                                    }
//                                }
//                        );
//                    }
            AppSession.saveUser(mUser)
            showProfileData()
        } else Notify.Toast("No data found")
    }

    //    //************************************************************
    //    private void updateProfile(String nickName, String media)
    //    //************************************************************
    //    {
    //        UpdateProfileRequest request = new UpdateProfileRequest();
    //
    //        if (TextUtils.isEmpty(nickName)) {
    //            request.setNickName(mUser.getChatNickName());
    //        } else {
    //            request.setNickName(nickName);
    //        }
    //
    //        if (TextUtils.isEmpty(media)) {
    //            if (mUser.getProfileImage() != null && !mUser.getProfileImage().isEmpty()) {
    //
    //                String[] splits = mUser.getProfileImage().split("file_name=");
    //                if (splits.length == 2) {
    //                    request.setProfileImage(splits[1]);
    //                } else {
    //                    request.setProfileImage(" ");
    //                }
    //            } else {
    //
    //
    //            }
    //
    //        } else {
    //            request.setProfileImage(media);
    //        }
    //
    //        if (fileHasExtension(request.getProfileImage())) {
    //            Log.d(TAG, "Profile_Fragment_Management updateProfile: " + Constants.END_POINT + RequestCodes.API_END_POINTS.UPDATE_PROFILE +
    //                    " Request: " +
    //                    "chat_user_id= " + mUser.getChatUserId() + " profile Request" + request.toString());
    //            NetworkCall.make()
    //                    .setCallback(this)
    //                    .setTag(RequestCodes.API.UPDATE_PROFILE)
    //                    .autoLoadingCancel(Utills.getLoading(requireActivity(), "Uploading..."))
    //                    .enque(Network.apis().updateProfile(
    //                            mUser.getChatUserId(), request))
    //                    .execute();
    //        }
    //
    //    }


    //************************************************************
    override fun onFailure(
        call: Call<*>?, response: BaseResponse,
        tag: Any
    ) //************************************************************
    {
        Notify.Toast(response.message)
    }

    override fun onSettingsClick(settingsModel: SettingsModel) {
        // ESSENTIAL FOR OVER RIDE
    }

    override fun onSettingsClick(position: Int) {
        when (position) {
            0 -> startActivity(Intent(requireActivity(), PrivacyActivity::class.java))
            1 -> startActivity(Intent(requireActivity(), ChatSettingsActivity::class.java))
            2 -> Notify.Toast("Coming soon!")
            3 -> startActivity(Intent(requireActivity(), AutoLockSettingActivity::class.java))
            4 -> startActivity(Intent(requireActivity(), ImportExportActivity::class.java))
            5, 6 -> Notify.Toast("Coming soon!")
        }
    }

    companion object {
        //************************************************************
        fun newInstance(): ProfileManageFragment //************************************************************
        {
            return ProfileManageFragment()
        }

        @Throws(WriterException::class)
        fun generateQrCode(myCodeText: String?): Bitmap {
            val hintMap = Hashtable<EncodeHintType, ErrorCorrectionLevel>()
            hintMap[EncodeHintType.ERROR_CORRECTION] = ErrorCorrectionLevel.H // H = 30% damage
            val writer = QRCodeWriter()
            val size = 800
            val bitMatrix = writer.encode(myCodeText, BarcodeFormat.QR_CODE, size, size)
            val width = bitMatrix.width
            val height = bitMatrix.height
            val pixels = IntArray(width * height)
            for (y in 0 until height) {
                val offset = y * width
                for (x in 0 until width) {
                    pixels[offset + x] =
                        if (bitMatrix[x, y]) AndroidUtil.getColor(R.color.faded_black) else Color.TRANSPARENT
                }
            }
            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height)
            return bitmap
        }
    }
}