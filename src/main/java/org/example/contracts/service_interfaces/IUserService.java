package org.example.contracts.service_interfaces;

import org.example.contracts.binding.UserBinding;
import org.example.contracts.request.UserRequest;
import org.example.contracts.response.PageResponse;
import org.example.contracts.response.UserResponse;


public interface IUserService {
    PageResponse<UserResponse> readPagedFilteredList(UserRequest request);
    UserResponse readElement(UserRequest request); // по сути можно просто айди
    UserResponse create(UserBinding model);
    UserResponse update(UserBinding model);
    UserResponse delete(UserBinding model);
}
