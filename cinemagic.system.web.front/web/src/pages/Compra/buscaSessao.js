import React, { useState } from 'react';

import api from '../../services/api';
import { Link } from 'react-router-dom';
import { FiMenu, FiSearch, FiCreditCard, FiMapPin } from 'react-icons/fi'
import { FlatList } from 'flatlist-react';

const [sessoes, setSessoes] = useState([]);

const id = localStorage.getItem('id');

useEffect(() => {
    api.get('sessoes', {
        headers: {
            Authorization: id,
        }
    })
}, [id]);






async function loadSessoes() {
    const response = await api.get('/sessoes');

    setSessoes(response.data);

}

useEffect(() => { loadSessoes() }, []);