//package com.devbeans.io.chat.activities
//
//class camera {
//
//
//    private var binding: FragmentCameraBinding? = null
//    private val _binding get() = binding!!
//
//    private var imageCapture: ImageCapture? = null
//    private var videoCapture: VideoCapture<Recorder>? = null
//    private var recording: Recording? = null
//
//    private lateinit var cameraExecutorService: ExecutorService
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentCameraBinding.inflate(layoutInflater,container,false)
//        return _binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Request camera permissions
//        if (allPermissionGranted()){
//            startCamera()
//        }else {
//            ActivityCompat.requestPermissions(requireActivity(), REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
//        }
//
//        // Set up the listeners for take photo and video capture buttons
//        _binding.imageCaptureButton.setOnClickListener { takePhoto() }
//        _binding.videoCaptureButton.setOnClickListener { captureVideo() }
//
//        cameraExecutorService = Executors.newSingleThreadExecutor()
//    }
//
//
//    private fun takePhoto(){
//        //First, get a reference to the ImageCapture use case.
//        // If the use case is null, exit out of the function.
//        // This will be null If we tap the photo button before image capture is set up.
//        // Without the return statement, the app would crash if it was null.
//        val imageCapture = imageCapture ?: return
//
//        //create a MediaStore content value to hold the image.
//        // Use a timestamp so the display name in MediaStore will be unique.
//        val name = SimpleDateFormat(FILENAME_FORMAT, Locale.getDefault()).format(System.currentTimeMillis())
//        //This class is used to store a set of values that the ContentResolver can process.
//        //ContentResolver class provides applications access to the content model.
//        val contentValues = ContentValues().apply {
//            //MediaStore is contract between the media provider and applications.
//            // Contains definitions for the supported URIs and columns.
//            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
//            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
//            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P){
//                put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/SplashApp-Images")
//            }
//        }
//
//        //Create an OutputFileOptions object.
//        // This object is where we can specify things about how we want our output to be.
//        // We want the output saved in the MediaStore so other apps could display it,
//        // so add our MediaStore entry.
//        val outputOptions = ImageCapture.OutputFileOptions
//            .Builder(requireActivity().contentResolver,MediaStore.Images.Media.EXTERNAL_CONTENT_URI,contentValues)
//            .build()
//
//        //Call takePicture() on the imageCapture object.
//        // Pass in outputOptions, the executor, and a callback for when the image is saved
//        imageCapture.takePicture(outputOptions,ContextCompat.getMainExecutor(requireContext()),
//            object : ImageCapture.OnImageSavedCallback{
//
//                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
//                    val msg = "Photo capture succeeded: ${outputFileResults.savedUri}"
//                    Toast.makeText(requireContext(),msg,Toast.LENGTH_SHORT).show()
//                    Log.d(TAG,msg)
//                }
//
//                //In the case that the image capture fails or saving the image capture fails,
//                // add in an error case to log that it failed.
//                override fun onError(exception: ImageCaptureException) {
//                    Log.e(TAG,"Photo Captured failed: ${exception.message}",exception)
//                }
//            })
//    }
//
//    private fun captureVideo(){
//        //Check if the VideoCapture use case has been created: if not, do nothing.7
//        val videoCapture = videoCapture ?: return
//
//        //Disable the UI until the request action is completed by CameraX
//        _binding.videoCaptureButton.isEnabled = false
//
//        //If there is an active recording in progress, stop it and release the current recording.
//        // We will be notified when the captured video file is ready to be used by our application.
//        val currentRecording = recording
//        if (currentRecording != null){
//            currentRecording.stop()
//            recording = null
//            return
//        }
//
//        // we create our intended MediaStore video content object,
//        // with system timestamp as the display name(so we could capture multiple videos).
//        val name = SimpleDateFormat(FILENAME_FORMAT, Locale.getDefault()).format(System.currentTimeMillis())
//        //ContentValue class is used to store a set of values that the ContentResolver can process.
//        // ContentResolver class provides applications access to the content model.
//        val contentValues = ContentValues().apply {
//            put(MediaStore.MediaColumns.DISPLAY_NAME,name)
//            put(MediaStore.MediaColumns.MIME_TYPE, "video/mp4")
//            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P ) {
//                put(MediaStore.Video.Media.RELATIVE_PATH,"Movies/SplashApp-Videos")
//            }
//        }
//
//        //Create a MediaStoreOutputOptions.Builder with the external content option.
//        //MediaStoreOutputOptions class providing options for storing output to MediaStore.
//        val mediaStoreOutputOptions = MediaStoreOutputOptions.Builder(
//            requireActivity().contentResolver,MediaStore.Video.Media.EXTERNAL_CONTENT_URI
//        )//Set the created video contentValues to the MediaStoreOutputOptions.Builder, and build our MediaStoreOutputOptions instance.
//            .setContentValues(contentValues).build()
//
//        //Configure the output option to the Recorder of VideoCapture<Recorder> and enable audio recording
//        recording = videoCapture.output
//            .prepareRecording(requireContext(),mediaStoreOutputOptions).apply {
//                if (PermissionChecker.checkSelfPermission(requireContext(),Manifest.permission.RECORD_AUDIO)
//                    == PermissionChecker.PERMISSION_GRANTED) {
//                    withAudioEnabled()
//                }
//            }//Start this new recording, and register a lambda VideoRecordEvent listener.
//            .start(ContextCompat.getMainExecutor(requireContext())){ recordEvent ->
//
//                when(recordEvent) {
//                    //When the request recording is started by the camera device,
//                    // toggle the "Start Capture" button text to say "Stop Capture".
//                    is VideoRecordEvent.Start -> {
//                        _binding.videoCaptureButton.apply {
//                            text = getString(R.string.stop_capture)
//                            isEnabled = true
//                        }
//                    }
//                    //When the active recording is complete, notify the user with a toast,
//                    // and toggle the "Stop Capture" button back to "Start Capture", and re-enable it
//                    is VideoRecordEvent.Finalize -> {
//                        _binding.videoCaptureButton.apply {
//                            text = getString(R.string.start_capture)
//                            isEnabled = true
//                        }
//                        if(!recordEvent.hasError()){
//                            val msg = "Video Capture Succeed: " + "${recordEvent.outputResults.outputUri}"
//                            Toast.makeText(requireContext(),msg,Toast.LENGTH_LONG).show()
//                            Log.d(TAG,msg)
//                        }else {
//                            recording?.close()
//                            recording = null
//                            Log.e(TAG,"Video Capture Ends with an Error: " + "${recordEvent.error}")
//                        }
//                    }
//                }
//            }
//    }
//
//    private fun startCamera(){
//        // User ProcessCameraProvider Bcs A singleton which can be used to bind the lifecycle of cameras
//        // to any LifecycleOwner within an application's process.
//        // Retrieve it with getInstance
//        // This eliminates the task of opening and closing the camera since CameraX is lifecycle-aware.
//        val cameraFutureProvider = ProcessCameraProvider.getInstance(requireContext())
//        //Registers a listener to be run  on the given executor.
//        // The listener will run when the Future's computation is complete  or,
//        // if the computation is already complete, immediately.
//        cameraFutureProvider.addListener({
//            // Used to bind the lifecycle of cameras to the lifecycle owner
//            val cameraProvider: ProcessCameraProvider = cameraFutureProvider.get()
//
//            // Preview use case that provides a camera preview stream for displaying on-screen.
//            val preview = Preview.Builder().build().also {
//                // Decide how the surface we using
//                // get a surface provider from viewfinder, and then set it on the preview.
//                it.setSurfaceProvider(_binding.viewFinder.surfaceProvider)
//            }
//
//            val recorder = Recorder.Builder()
//                .setQualitySelector(QualitySelector.from(Quality.HIGHEST,
//                    //Add a FallbackStrategy to the existing QualitySelector creation.
//                    // This allows CameraX to pick up a supported resolution
//                    // if the required Quality.HIGHEST is not supportable with the imageCapture use case.
//                    FallbackStrategy.higherQualityOrLowerThan(Quality.SD)))
//                .build()
//            videoCapture = VideoCapture.withOutput(recorder)
//
//            imageCapture = ImageCapture.Builder().build()
//
//            /*
//            //ImageAnalysis use case providing CPU accessible images for an app to perform image analysis on.
//            //ImageAnalysis acquires images from the camera via an ImageReader.
//            // Each image is provided to an ImageAnalysis.Analyzer function which can be implemented by application code
//            //where it can access image data for application analysis via an ImageProxy.
//            val imageAnalyzer = ImageAnalysis.Builder().build().also {
//                it.setAnalyzer(cameraExecutorService,LuminosityAnalyzer { luma ->
//                    Log.d(TAG,"The Average luminosity: $luma")
//                })
//            }
//            */
//
//
//            // Select back camera as a default
//            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
//            try {
//                // Unbind use case before rebinding
//                // This will initiate a close of every currently open camera.
//                cameraProvider.unbindAll()
//
//                // Bind use cases to camera
//                cameraProvider.bindToLifecycle(
//                    requireActivity(),cameraSelector,preview,imageCapture,videoCapture
//                )
//            }catch (e:Exception){
//                Log.e(TAG, "Use case binding failed",e)
//            }
//        }// This returns an Executor that runs on the main thread.
//            ,ContextCompat.getMainExecutor(requireContext()))
//    }
//
//    //The analyzer logs the average luminosity of the image.
//    // To create an analyzer, we override the analyze function in a class that implements the ImageAnalysis.Analyzer interface.
//    private class LuminosityAnalyzer(private val listener: LumaListener) : ImageAnalysis.Analyzer{
//
//        private fun ByteBuffer.toByteArray(): ByteArray{
//            rewind() //Rewind the Buffer to zero
//            val data = ByteArray(remaining())
//            get(data) //Copy the buffer into a byte array
//            return data //Return byte array
//        }
//
//        override fun analyze(image: ImageProxy) {
//            val buffer = image.planes[0].buffer
//            val data = buffer.toByteArray()
//            val pixels = data.map { it.toInt() and 0xFF }
//            val luma = pixels.average()
//
//            listener(luma)
//            //The application is responsible for calling ImageProxy.close() to close the image.
//            // Failing to close the image will cause future images to be stalled or dropped depending on the backpressure strategy.
//            image.close()
//        }
//    }
//
//    // Send Permission To access to camera
//    private fun allPermissionGranted() = REQUIRED_PERMISSIONS.all {
//        ContextCompat.checkSelfPermission(requireContext(),it) ==
//                PackageManager.PERMISSION_GRANTED
//    }
//
//    //Callback for the result from requesting permissions.
//    // This method is invoked for every call on requestPermissions(String[], int).
//    @Deprecated("Deprecated in Java")
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        if (requestCode == REQUEST_CODE_PERMISSIONS){
//            if (allPermissionGranted()){
//                startCamera()
//            }else {
//                Toast.makeText(requireContext(),"Permission not granted by the user.",Toast.LENGTH_SHORT).show()
//                activity?.finish()
//            }
//        }
//    }
//
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//        cameraExecutorService.shutdown()
//    }
//
//
//
//    companion object {
//        private const val TAG = "CAMERAX"
//        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SS"
//        private const val REQUEST_CODE_PERMISSIONS = 10
//        private val REQUIRED_PERMISSIONS =
//            mutableListOf(
//                Manifest.permission.CAMERA,
//                Manifest.permission.RECORD_AUDIO
//            ).apply {
//                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P){
//                    add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                }
//            }.toTypedArray()
//    }
//}