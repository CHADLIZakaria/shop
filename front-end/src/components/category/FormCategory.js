import React, {useEffect, useState} from 'react'
import Title from '../Title'
import {ErrorMessage, Field, Form, Formik} from 'formik'
import { useParams } from 'react-router-dom'
import CategoryService from '../../service/CategoryService'

const FormCategory = () => {
    const {id} = useParams()
    const [category, setCategory] = useState({})
    useEffect(() => {
        CategoryService.findCategoryById(id).then(value => setCategory(value)) 
    }, [])
    
    return (
        <>
            <Title title={"Update Category"} />
            <Formik 
                initialValues={{ name: category.name}} 
                enableReinitialize={true}
                validate={(values) => {
                    const errors = {}
                    if(!values.name) {
                        errors.name="Name is required"
                    }
                    return errors
                }}
                onSubmit={(values) => {
                    console.log(values)
                }}>
                <Form>
                    <label>Name</label>
                    <Field type="text" name="name"  />
                    <ErrorMessage component="span" className='text-danger' name='name'/>
                    <button className="btn btn-primary" type="submit">Submit</button>
                </Form>
            </Formik>
        </>
    )
}

export default FormCategory