import React from 'react';
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button
} from 'reactstrap';
import img from '../../assets/pulpFic.jpg';
import "./styles.css"


const Example = (props) => {
    return (
        <div>
            <Card>
                <CardImg top width="100%" src={img} alt="Card image cap" />
                <CardBody>
                    <CardTitle tag="h5">Titulo do filme</CardTitle>
                    <CardSubtitle tag="h6" className="mb-2 text-muted">DESCRIÇAO 2</CardSubtitle>
                    <CardText>Esse texto resume o filme e suas caracteristicas</CardText>
                    <Button>Assistir</Button>
                </CardBody>
            </Card>
        </div>
    );
};

export default Example;