import axios from 'axios';

export default {

  fetchPets() {
    return axios.get('/pets')
  },

  

}
