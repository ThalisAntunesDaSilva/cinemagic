import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Home from './pages/Home';
import CadastroCliente from './pages/CadastroCliente';
import Login from './pages/login';





export default function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Login} />
                <Route path="/CadastroCliente" exact component={CadastroCliente} />
                <Route path="/Home" exact component={Home} />

            </Switch>
        </BrowserRouter>
    );

}