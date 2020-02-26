import React, { Component } from 'react'
//import { Link } from 'react-router-dom';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { deleteProjectTask } from '../../actions/projectTaskActions';

class ProjectTaskItem extends Component {

    onDeleteClick(pt_id){
        console.log('id id is : ' + pt_id);
        this.props.deleteProjectTask(pt_id);
    }

    render() {
        const { project_tasks } = this.props;
        return (
            <div className="card mb-1 bg-light">
                <div className="card-header text-primary">
                    ID: {project_tasks.id}
                </div>
                <div className="card-body bg-light">
                    <h5 className="card-title">{project_tasks.summary}</h5>
                    <p className="card-text text-truncate ">{project_tasks.acceptanceCriteria}</p>
                    <a href='' className="btn btn-primary"> View / Update</a>
                    <button className="btn btn-danger ml-4"
                    onClick={this.onDeleteClick.bind(this, project_tasks.id)}
                    >Delete</button>
                </div>
            </div>
        )
    }
}
ProjectTaskItem.prototypes = {
    deleteProjectTask: PropTypes.func.isRequired
   // project_tasks: PropTypes.object.isRequired
}

// const mapStateToProps = state => ({
//     project_tasks: state.project_tasks
// })

export default connect(null, {deleteProjectTask}) (ProjectTaskItem);