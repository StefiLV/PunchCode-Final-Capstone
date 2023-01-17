import axios from 'axios';


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
