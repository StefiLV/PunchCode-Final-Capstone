import axios from 'axios';

export default {
    list(){
        return axios.get('http://localhost:8080/api/events');
    },

}
