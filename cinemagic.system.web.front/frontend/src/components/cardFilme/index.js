import React from 'react';
import hp from '../../assets/hp.png'
import './styles.css';

import {
  Card, CardText, CardBody, CardLink,
  CardTitle, CardSubtitle, Button
} from 'reactstrap';

const Example = (props) => {
  return (
    <div>
      <Card>
        <CardBody>
          <CardTitle tag="h5">Seção Alegrete-RS</CardTitle>
          <CardSubtitle tag="h6" className="mb-2 text-muted">Filmes em sessão</CardSubtitle>
        </CardBody>
       <div className="filmes">
        <img width="20%" height="20%" src={hp} alt="Card image cap" />
        <img width="20%" height="20%" src={hp} alt="Card image cap" />
        <img width="20%" height="20%" src={hp} alt="Card image cap" />

        </div>
        <CardBody>
        <div className="filmes">
          <CardText>Harry Potter: 13:00</CardText>
          <CardText>Homem-Aranha: 16:00</CardText>
          <CardText>Todo Poderoso: 20:00</CardText>
          </div>
         <div className="compra"> <Button color="danger">Compre já</Button></div>


        </CardBody>
      </Card>
    </div>
  );
};

export default Example;