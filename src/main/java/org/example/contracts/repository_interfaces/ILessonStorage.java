package org.example.contracts.repository_interfaces;

import org.example.contracts.binding.LessonBinding;
import org.example.contracts.request.LessonRequest;
import org.example.contracts.response.LessonResponse;

import java.util.ArrayList;
import java.util.Optional;

public interface ILessonStorage {
    ArrayList<LessonResponse> getFullList();
    ArrayList<LessonResponse> getFilteredList(LessonRequest model);
    ArrayList<LessonResponse> getPagedList(LessonRequest model);
    Optional<LessonResponse> getElement(LessonRequest model);
    Optional<LessonResponse> insert(LessonBinding model);
    Optional<LessonResponse> update(LessonBinding model);
    Optional<LessonResponse> delete(LessonBinding model);
}
