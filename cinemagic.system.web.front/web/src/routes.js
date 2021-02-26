import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Home from './pages/Home';
import CadastroCliente from './pages/CadastroCliente';





export default function Routes(){
return(
<BrowserRouter>
<Switch>
<Route path= "/" exact component={Home}/>
<Route path= "/CadastroCliente" exact component={CadastroCliente}/>


</Switch>
</BrowserRouter>
);

}