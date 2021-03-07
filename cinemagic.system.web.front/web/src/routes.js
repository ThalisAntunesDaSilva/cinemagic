import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Home from './pages/Home';
import CadastroCliente from './pages/CadastroCliente';
import Login from './pages/login';





export default function Routes(){
return(
<BrowserRouter>
<Switch>
<Route path= "/" exact component={Home}/>
<Route path= "/CadastroCliente" exact component={CadastroCliente}/>
<Route path = "/Login" exact component={Login}/>

</Switch>
</BrowserRouter>
);

}