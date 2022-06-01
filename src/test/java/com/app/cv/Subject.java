package com.app.cv;

public enum Subject {
    TAM("TAM"),
    HIND("HIND"),
    ENG("ENG"),
    MAT("MAT"),
    EVS1("EVS1"),
    EVS2("EVS2");

    private final String subjectName;

    Subject(String subjectName) {
        this.subjectName = subjectName;
    }
}
