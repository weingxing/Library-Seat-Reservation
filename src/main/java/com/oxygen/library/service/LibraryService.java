package com.oxygen.library.service;

import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.entity.Library;

public interface LibraryService {

    public boolean addLibrary(Library library) throws Exception;

    public boolean deleteLibrary(int lid) throws Exception;

    public boolean updateLibrary(Library library) throws Exception;

    public PageInfo<Library> getLibraryByPage(PageRequest request) throws Exception;

    public Library getLibraryByName(String name) throws Exception;
}
