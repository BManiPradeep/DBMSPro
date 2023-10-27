package com.example.DBMSPro.Repository;

import com.example.DBMSPro.Models.OfflineUser;

import java.util.List;

public interface OfflineUserRepository {
    int addOfflineUser(OfflineUser offlineUser);
    List<OfflineUser> getallofflineUser();
}
