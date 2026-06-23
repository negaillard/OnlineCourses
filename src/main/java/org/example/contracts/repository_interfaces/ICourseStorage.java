package org.example.contracts.repository_interfaces;

import org.example.contracts.binding.CourseBinding;
import org.example.contracts.request.CourseRequest;
import org.example.contracts.response.CourseResponse;

import java.util.ArrayList;
import java.util.Optional;

public interface ICourseStorage {
    ArrayList<CourseResponse> getFullList();
    ArrayList<CourseResponse> getFilteredList(CourseRequest model);
    ArrayList<CourseResponse> getPagedList(CourseRequest model);
    Optional<CourseResponse> getElement(CourseRequest model);
    Optional<CourseResponse> insert(CourseBinding model);
    Optional<CourseResponse> update(CourseBinding model);
    Optional<CourseResponse> delete(CourseBinding model);
}
