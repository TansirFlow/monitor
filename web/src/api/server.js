import request from '@/utils/request.js'

export const getServerInfoListServer=()=>{
    return request.get("/server/status")
}