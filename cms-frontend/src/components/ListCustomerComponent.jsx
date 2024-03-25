import React, {useEffect, useState} from 'react'
import { deleteCustomer, listCustomers } from '../Services/CustomerService'
import { useNavigate } from 'react-router-dom';

const ListCustomerComponent = () => {

   const [customers, setCustomers] = useState([])

   const navigator = useNavigate();

   useEffect(() => {
      getAllCustomers();
   }, [])

   function getAllCustomers() {
      listCustomers().then((response) => {
         setCustomers(response.data);
      }).catch(error => {
         console.error(error);
      })
   }

   function addNewCustomer() {
      navigator('/add-customer')
   }

   function editCustomer(id){
      navigator(`/edit-customer/${id}`);
  }

  function removeCustomer(id) {
      console.log(id);

      deleteCustomer(id).then((response) => {
         getAllCustomers();
      }).catch((error) => {
         console.error(error);
      })
  }


  return (
    <div className='container'>

      <h2 className='text-center' style={{marginTop: '10px'}}>🖥️ Our Customers 🖥️</h2>
      <br />
      <table className='table table-hover table-bordered table-light'>
         <thead className='thead-dark'> 
            <tr>
               <th>Customer Id</th>
               <th>Customer First Name</th>
               <th>Customer Last Name</th>
               <th>Customer Email id</th>
               <th>Actions</th>
            </tr>
         </thead>
         <tbody>
            {
               customers.map(customer => 
                  <tr key={customer.id}>
                     <td>{customer.id}</td>
                     <td>{customer.firstName}</td>
                     <td>{customer.lastName}</td>
                     <td>{customer.email}</td>
                     <td>
                     <button onClick={ () => editCustomer(customer.id)} className="btn btn-outline-success">Update </button>
                     <button onClick={ () => removeCustomer(customer.id)} className="btn btn-outline-danger" 
                        style={{marginLeft: '10px'}}
                     >Delete<i className="bi bi-trash"></i></button>
                     </td>
                  </tr>)
            }
         </tbody>
      </table><br />
      <div className='d-flex justify-content-center'>
        <button type='button' className='btn btn-primary mb-2' onClick={addNewCustomer}>
          Add Customer
        </button>
      </div>
    </div>
  )
}

export default ListCustomerComponent