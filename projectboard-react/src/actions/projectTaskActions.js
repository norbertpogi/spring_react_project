import axios from 'axios';
import { GET_ERRORS, GET_PROJECT_TASKS, DELETE_PROJECT_TASK } from './types';

const api_endpoint = 'http://localhost:8080/api/board';

export const addProjectTask = (project_task, history) => async dispatch => {
    try {
        await axios.post(api_endpoint, project_task);
        history.push('/');
        dispatch({
            type: GET_ERRORS,
            payload: {}
        });
    } catch (error) {
        dispatch({
            type: GET_ERRORS,
            payload: error.response.data
        });
    }
};

export const getBacklog = () => async dispatch => {
    const res = await axios.get(api_endpoint + '/all')
    dispatch({
        type: GET_PROJECT_TASKS,
        payload: res.data
    })
};

export const deleteProjectTask = pt_id => async dispatch => {
    if (window.confirm(`You are deleting project task ${pt_id}, this action cannot be undone`)) {        
        await axios.delete(api_endpoint + '/' + pt_id );
        dispatch({
            type: DELETE_PROJECT_TASK,
            payload: pt_id
        });
    }
}