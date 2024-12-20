<script setup>
import {ref,onMounted} from 'vue'
import {getServerInfoListServer} from '@/api/server'
const serverInfoList=ref([])
const getServerInfo=async()=>{
    let result=await getServerInfoListServer()
    serverInfoList.value=result.data
    for(let i=0;i<serverInfoList.value.length;++i){
        if(serverInfoList.value[i].status==null){
            serverInfoList.value.splice(i,1)
        }
    }
}
onMounted(()=>{
    getServerInfo()
})
</script>

<template>
<n-flex justify="center" style="border:1px solid red;justify-content: center;">
    <n-flex justify="center" style="border:1px solid red;width:800px;max-width:95%;justify-content: center;">
        <n-card title="华为云香港2C4G" v-for="(item,index) in serverInfoList" :key="index">
            <template #header-extra>
                Hong Kong
            </template>
            <n-space>
                <n-progress type="dashboard" gap-position="bottom" :percentage="item.status.cpu.usage" />
                <n-progress type="dashboard" gap-position="bottom" :percentage="item.status.ram.percent" />
                <n-progress type="dashboard" gap-position="bottom" :percentage="item.status.disk.percent" />
            </n-space>
            <div>{{ serverInfo }}</div>
            <template #footer>
            #footer
            </template>
            <template #action>
            #action
            </template>
        </n-card>
    </n-flex>
    
</n-flex>

</template>

<style scoped>
</style>