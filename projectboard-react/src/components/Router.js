import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import App from '../App';
import AddProject from './ProjectTask/AddProjectTask';
import {Provider} from 'react-redux';
import store from '../../src/store';

function Router() {
    return (
        <Provider store={store}>
            <BrowserRouter>
                <div>
                    <Switch>
                        <Route path="/" component={App} exact />
                        <Route component={AddProject} exact />
                    </Switch>
                </div>
            </BrowserRouter>
        </Provider>

    )
}

export default Router;