package org.example.contracts.repository_interfaces;

import org.example.contracts.binding.UserBinding;
import org.example.contracts.request.UserRequest;
import org.example.contracts.response.UserResponse;

import java.util.ArrayList;
import java.util.Optional;

public interface IUserStorage {
    ArrayList<UserResponse> getFullList();
    ArrayList<UserResponse> getFilteredList(UserRequest model);
    ArrayList<UserResponse> getPagedList(UserRequest model);
    Optional<UserResponse> getElement(UserRequest model);
    Optional<UserResponse> insert(UserBinding model);
    Optional<UserResponse> update(UserBinding model);
    Optional<UserResponse> delete(UserBinding model);
}
