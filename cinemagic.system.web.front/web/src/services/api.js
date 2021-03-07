import axios from 'axios';

const api = axios.create({
    baseURL: 'http://192.168.18.163:8080'

})

export default api;