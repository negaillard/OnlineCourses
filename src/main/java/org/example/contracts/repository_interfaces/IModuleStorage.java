package org.example.contracts.repository_interfaces;

import org.example.contracts.binding.ModuleBinding;
import org.example.contracts.request.ModuleRequest;
import org.example.contracts.response.ModuleResponse;

import java.util.ArrayList;
import java.util.Optional;

public interface IModuleStorage {
    ArrayList<ModuleResponse> getFullList();
    ArrayList<ModuleResponse> getFilteredList(ModuleRequest model);
    ArrayList<ModuleResponse> getPagedList(ModuleRequest model);
    Optional<ModuleResponse> getElement(ModuleRequest model);
    Optional<ModuleResponse> insert(ModuleBinding model);
    Optional<ModuleResponse> update(ModuleBinding model);
    Optional<ModuleResponse> delete(ModuleBinding model);
}
