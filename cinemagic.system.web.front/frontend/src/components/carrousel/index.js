import React, { useState } from 'react';
import {
  Carousel,
  CarouselItem,
  CarouselControl,
  CarouselIndicators,
  CarouselCaption
} from 'reactstrap';
import image1 from '../../assets/cadastro.jpg';

const items = [
  {
    id: 1,
    altText: 'Slide 1',
    caption: 'Mulher Maravilha',
    legenda: 'Ela é muito forte'
  },
  {
    id: 2,
    altText: 'Slide 2',
    caption: 'A Hora do Pesadelo',
    legenda: 'Você ficará com medo!'
  },
  {
    id: 3,
    altText: 'Slide 3',
    caption: 'Tropa de Elite',
    legenda: 'Cade o baiano?'
  }
];

const Example = (props) => {
 //estados
    const [activeIndex, setActiveIndex] = useState(0);
  const [animating, setAnimating] = useState(false);
//Movimentação
  const next = () => {
    if (animating) return;
    const nextIndex = activeIndex === items.length - 1 ? 0 : activeIndex + 1;
    setActiveIndex(nextIndex);
  }

  const previous = () => {
    if (animating) return;
    const nextIndex = activeIndex === 0 ? items.length - 1 : activeIndex - 1;
    setActiveIndex(nextIndex);
  }

  const goToIndex = (newIndex) => {
    if (animating) return;
    setActiveIndex(newIndex);
  }


  //Conteúdo slides
  const slides = items.map((item) => {
    return (
      <CarouselItem
        className="custom-tag"
        tag="div"
        key={item.id}
        onExiting={() => setAnimating(true)}
        onExited={() => setAnimating(false)}
      >
         <img src={image1} className="sliderimg"/>
        <CarouselCaption className="legenda" captionText={item.legenda} captionHeader={item.caption} />
      </CarouselItem>
    );
  });

  return (
    <div>
      <style>
        {
          `.custom-tag {
              max-width: 100%;
              height: 500px;
              background-color: black;
            }`
        }
      </style>
      <Carousel
        activeIndex={activeIndex}
        next={next}
        previous={previous}
      >
        <CarouselIndicators items={items} activeIndex={activeIndex} onClickHandler={goToIndex} />
        {slides}
        <CarouselControl direction="prev" directionText="Previous" onClickHandler={previous} />
        <CarouselControl direction="next" directionText="Next" onClickHandler={next} />
      </Carousel>
    </div>
  );
}

export default Example;