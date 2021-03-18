import React, { useState } from 'react';
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button, Alert,
    NavbarText, NavLink, NavItem, Navbar, NavbarBrand, Nav, Collapse, Progress
} from 'reactstrap';
import { Toast, ToastBody, ToastHeader } from 'reactstrap';

import img from '../../assets/pulpFic.jpg';
import img2 from '../../assets/Django.jpg';
import "./styles.css"

const msg = () => {
    return Alert.alert("Mensagem")
}


const Example = (props) => {

    const [isOpen, setIsOpen] = useState(false);

    const toggle = () => setIsOpen(!isOpen);

    return (
        <div>
            <Navbar color="light" light expand="md">
                <NavbarBrand href="/">Menu Iniciar</NavbarBrand>
                <Collapse isOpen={isOpen} navbar>
                    <Nav className="mr-auto" navbar>
                        <NavItem>
                            <NavLink href="">Enderço 2</NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink href="">Enderço 2</NavLink>
                        </NavItem>
                    </Nav>
                    <NavbarText>Cinemagic</NavbarText>
                </Collapse>
            </Navbar>

            <div class ="posNavBar">
                ffffffff
            </div>


            <Card>
                <CardImg top width="100%" src={img2} alt="Card image cap" />
                <CardBody>
                    <CardTitle tag="h5">Django Livre</CardTitle>
                    <CardSubtitle tag="h6" className="mb-2 text-muted">Diretor: Quentin Tarantino</CardSubtitle>
                    <Progress animated value="90">90%</Progress>
                    <CardText>No sul dos Estados Unidos, o ex-escravo Django faz uma aliança inesperada com o caçador de recompensas Schultz.
                        Para caçar os criminosos mais procurados do país e resgatar sua esposa de um fazendeiro que força seus escravos a participar de competições mortais.</CardText>
                    <Button color="primary">Assistir</Button>{' '}
                </CardBody>
            </Card>


            <Card>
                <CardImg top width="100%" src={img} alt="Card image cap" />
                <CardBody>
                    <CardTitle tag="h5">Pulp Fiction: Tempo de Violência</CardTitle>
                    <CardSubtitle tag="h6" className="mb-2 text-muted">Diretor: Quentin Tarantino</CardSubtitle>
                    <Progress animated value="80">80%</Progress>
                    <CardText>Os caminhos de vários criminosos se cruzam nestas três histórias de Quentin Tarantino.
                        Um pistoleiro se apaixona pela mulher de seu chefe, um boxeador não se sai bem em uma luta e um casal tenta executar um plano de roubo que foge do controle.</CardText>
                    <Button color="primary">Assistir</Button>{' '}
                </CardBody>
            </Card>
            <div className="p-3 bg-info my-2 rounded">
                <Toast>
                    <ToastHeader>
                        Cinemagic
                    </ToastHeader>
                    <ToastBody>
                        O melhor e maior Cinema Stremming do Mundo!
                    </ToastBody>
                </Toast>
            </div>
        </div>
    );
};



export default Example;