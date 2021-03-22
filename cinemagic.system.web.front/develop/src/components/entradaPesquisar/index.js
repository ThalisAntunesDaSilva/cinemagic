import React, {useState} from 'react';
import { Button, Input } from 'reactstrap';
import { FiSearch} from 'react-icons/fi';
import './styles.css';





const Example = (props) => {
 
 
 
 
  return (
        <div className="input-div">
    <Input name="email"  className="input w-25 p-3"/> 
      <Button color="danger" className="button">
      <FiSearch className="icon-search" size={16} color="#ffffff"/>
      </Button>
      </div>
  
  
  );
}

export default Example;