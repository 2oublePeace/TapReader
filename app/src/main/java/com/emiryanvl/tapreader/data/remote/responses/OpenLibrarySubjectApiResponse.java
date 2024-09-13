package com.emiryanvl.tapreader.data.remote.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpenLibrarySubjectApiResponse {

    @SerializedName("key")
    String key;

    @SerializedName("name")
    String name;

    @SerializedName("subject_type")
    String subjectType;

    @SerializedName("work_count")
    int workCount;

    @SerializedName("works")
    List<Work> works;

    public OpenLibrarySubjectApiResponse(String key, String name, String subjectType, int workCount, List<Work> works) {
        this.key = key;
        this.name = name;
        this.subjectType = subjectType;
        this.workCount = workCount;
        this.works = works;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public int getWorkCount() {
        return workCount;
    }

    public List<Work> getWorks() {
        return works;
    }

    public static class Work {

        @SerializedName("key")
        String key;

        @SerializedName("title")
        String title;

        @SerializedName("cover_id")
        int coverId;

        @SerializedName("authors")
        List<OpenLibrarySubjectApiResponse.Author> authors;

        public Work(String key, String title, int coverId, List<OpenLibrarySubjectApiResponse.Author> authors) {
            this.key = key;
            this.title = title;
            this.coverId = coverId;
            this.authors = authors;
        }

        public String getKey() {
            return key;
        }

        public String getTitle() {
            return title;
        }

        public int getCoverId() {
            return coverId;
        }

        public List<OpenLibrarySubjectApiResponse.Author> getAuthors() {
            return authors;
        }
    }

    public static class Author {

        @SerializedName("key")
        String key;

        @SerializedName("name")
        String name;

        public Author(String key, String name) {
            this.key = key;
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public String getName() {
            return name;
        }
    }
}
