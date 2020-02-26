import axios from 'axios';

const api_endpoint = 'http://localhost:8080/api/board';

export const addProjectTask = (project_task, history) => async dispatch => {
    await axios.post(api_endpoint, project_task);
    history.push('/');
};

