package com.emiryanvl.tapreader.data.remote.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpenLibrarySearchApiResponse {

    @SerializedName("docs")
    List<Doc> docs;

    public OpenLibrarySearchApiResponse(List<Doc> docs) {
        this.docs = docs;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public static class Doc {

        @SerializedName("title")
        String title;

        public Doc(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}
