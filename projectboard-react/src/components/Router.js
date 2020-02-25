import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import App from '../App';
import AddProject from './ProjectTask/AddProjectTask';

function Router() {
    return (
        <BrowserRouter>
            <div>
                <Switch>
                    <Route path="/" component={App} exact />
                    <Route component={AddProject} exact />
                </Switch>
            </div>
        </BrowserRouter>

    )
}

export default Router;