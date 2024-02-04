package net.zhuruoling.nekomemo.sync

import net.zhuruoling.nekomemo.client.NekoMemoSyncClient

object DataSync {
    private lateinit var syncClient: NekoMemoSyncClient
    var syncStatus = SyncStatus.DISABLED
        private set
    fun init(){

    }

    fun doSync(){

    }
}