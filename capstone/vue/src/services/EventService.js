import axios from 'axios';

// const http = axios.create({
//     baseURL: "http://localhost:8080"
// })

export default {
    list(){
        return axios.get('/api/events');
    },
    get(id) {
        return axios.get(`/events/${id}`)
      },

      getUsers(){
        return axios.get('/api/users')
    },
    

}
