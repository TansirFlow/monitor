//定制请求的实例

//导入axios  npm install axios
import axios from 'axios';
import { useTokenStore } from '@/stores/token.js'
import router from '@/router'
import { useMessage } from 'naive-ui'
import { useRoute } from 'vue-router';
const message=useMessage()
//定义一个变量,记录公共的前缀  ,  baseURL
const baseURL = '/api';
const instance = axios.create({ baseURL })

instance.interceptors.request.use(
    (config) => {
        const tokenStore = useTokenStore()
        if (tokenStore.token) {
            //在pinia中定义的响应式数据不需要value就可以使用
            config.headers.Authorization = tokenStore.token
        }
        return config;
    },
    (err) => {
        Promise.reject(err)
    }
)
//添加响应拦截器
instance.interceptors.response.use(
    result => {
        return result.data;
    },
    err => {
        if (err.response.status === 401) {
            
            console.log(router.currentRoute.value.path)
            if(router.currentRoute.value.path!=='/'){
                router.push('/login')
            }
            
        } else {
            // router.push('/500')
        }
        return Promise.reject(err);//异步的状态转化成失败的状态
    }
)

export default instance;