package com.devbeans.io.chat.utils.avatar;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.devbeans.io.chat.utils.Fitzpatrick;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Based in part on code from emoji-java
 */
public class EmojiParser {

    private final EmojiTree emojiTree;

    public EmojiParser(EmojiTree emojiTree) {
        this.emojiTree = emojiTree;
    }

    public @NonNull CandidateList findCandidates(@Nullable CharSequence text) {
        List<Candidate> results = new LinkedList<>();

        if (text == null) {
            return new CandidateList(results, false);
        }

        boolean allEmojis = text.length() > 0;

        for (int i = 0; i < text.length(); i++) {
            int emojiEnd = getEmojiEndPos(text, i);

            if (emojiEnd != -1) {
                EmojiDrawInfo drawInfo = emojiTree.getEmoji(text, i, emojiEnd);

                if (emojiEnd + 2 <= text.length()) {
                    if (Fitzpatrick.fitzpatrickFromUnicode(text, emojiEnd) != null) {
                        emojiEnd += 2;
                    }
                }

                results.add(new Candidate(i, emojiEnd, drawInfo));

                i = emojiEnd - 1;
            } else if (text.charAt(i) != ' '){
                allEmojis = false;
            }
        }

        allEmojis &= !results.isEmpty();

        return new CandidateList(results, allEmojis);
    }

    private int getEmojiEndPos(CharSequence text, int startPos) {
        int best = -1;

        for (int j = startPos + 1; j <= text.length(); j++) {
            EmojiTree.Matches status = emojiTree.isEmoji(text, startPos, j);

            if (status.exactMatch()) {
                best = j;
            } else if (status.impossibleMatch()) {
                return best;
            }
        }

        return best;
    }

    public static class Candidate {

        private final int           startIndex;
        private final int           endIndex;
        private final EmojiDrawInfo drawInfo;

        Candidate(int startIndex, int endIndex, EmojiDrawInfo drawInfo) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.drawInfo = drawInfo;
        }

        public EmojiDrawInfo getDrawInfo() {
            return drawInfo;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public int getStartIndex() {
            return startIndex;
        }
    }

    public static class CandidateList implements Iterable<Candidate> {
        public final List<EmojiParser.Candidate> list;
        public final boolean                     allEmojis;

        public CandidateList(List<EmojiParser.Candidate> candidates, boolean allEmojis) {
            this.list = candidates;
            this.allEmojis = allEmojis;
        }

        public int size() {
            return list.size();
        }

//        public boolean hasJumboForAll() {
//            for (Candidate candidate : list) {
//                if (!JumboEmoji.hasJumboEmoji(candidate.drawInfo)) {
//                    return false;
//                }
//            }
//            return true;
//        }

        @Override
        public @NonNull Iterator<Candidate> iterator() {
            return list.iterator();
        }
    }

}