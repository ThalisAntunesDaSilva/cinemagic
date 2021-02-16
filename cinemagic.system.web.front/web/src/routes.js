import React from 'react';
import {BrowserRouter, Route, Switch } from 'react-router-dom';


import Home from './pages/Home';
import Cadastro from './pages/Cadastro';
import Compra from './pages/Compra';



export default function Routes(){
return(
<BrowserRouter>
<Switch>
<Route path= "/" exact component={Home}/>
<Route path= "/Cadastro" component={Cadastro}/>
<Route path= "/Compra" component={Compra}/>

</Switch>
</BrowserRouter>
);

}