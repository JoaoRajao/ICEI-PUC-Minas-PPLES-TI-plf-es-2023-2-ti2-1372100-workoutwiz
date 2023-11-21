# WORKOUTWIZ


**Davi Andrade Rocha Melo de Oliveira, 1438646@sga.pucminas.br**

**João Vitor Pedersoli Rajão, 1438572@sga.pucminas.br**

**João Vítor Barrel Alves Dutra, 1439437@sga.pucminas.br**

**Pedro Arthur Oliveira Silva, 1426724@sga.pucminas.br**



---

Professores:

** Eveline Alonso Veloso **

** Hugo Bastos de Paula **

** Juliana Amaral Baroni de Carvalho **

---

_Curso de Engenharia de Software, Unidade Praça da Liberdade_

_Instituto de Informática e Ciências Exatas – Pontifícia Universidade Católica de Minas Gerais (PUC MINAS), Belo Horizonte – MG – Brasil_

---

_**
No contexto de um mundo altamente conectado e impulsionado pela tecnologia, a proposta do trabalho é desenvolver uma aplicação inovadora para a gestão de academias, visando aprimorar a experiência dos usuários. A aplicação busca personalizar e otimizar a jornada de saúde e bem-estar. Além disso, a ferramenta visa modernizar a administração interna das academias, simplificando agendamentos, controle de equipamentos e comunicação com os membros. O resultado relevante alcançado é a criação de uma plataforma completa que não apenas atende às necessidades dos usuários, mas também efetivamente transforma a maneira como as academias são gerenciadas, unindo tecnologia e bem-estar de forma inovadora e impactante.**.

---


## 1. Introdução

O projeto "WorkoutWiz" que apresentamos é uma aplicação inovadora focada no gerenciamento de academia, com o propósito central de oferecer aos indivíduos interessados em treinamento uma abordagem de rotina personalizada e eficaz, visando alcançar seus objetivos de saúde e boa forma.

### 1.1 Contextualização

Em um mundo onde a busca por um estilo de vida saudável é uma prioridade crescente,as academias desempenham um papel fundamental. Contudo, a abordagem tradicional muitas vezes não é suficientemente individualizada para satisfazer as necessidades individuais de cada um. Várias matérias publicadas pela ACSM's Alliance of Health and Fitness mostram que personalizar programas de exercícios e orientações nutricionais pode levar a resultados mais significativos e duradouros além de contribuir para sua saúde.
Além disso, a falta de personalização nos programas de treinamento pode reduzir o engajamento e dificultar o alcance dos objetivos de longo prazo. Daí surge a necessidade de soluções inovadoras como a nossa aplicação “WorkoutWiz”, que pretende preencher esta lacuna, proporcionando uma experiência personalizada para cada utilizador e indo ao encontro das expectativas atuais para uma jornada de treino eficiente e gratificante.

### 1.2 Problema

No cenário das academias contemporâneas, temos uma dificuldade de fornecer programas de exercícios e orientações nutricionais altamente customizadas para cada integrante com base em seus objetivos, limitações e níveis de condicionamento físico. As abordagens gerais muitas vezes levam à falta de motivação, à estagnação e até à desistência. Essa falta de customização pode ser percebida em academias de todos os portes, reduzindo a eficácia das rotinas de treinamento.
Além disso, outro desafio para as academias é a dificuldade de manter os associados engajados ao longo do tempo. As rotinas de exercícios muitas vezes tornam-se monótonas e previsíveis, levando à desmotivação e ao tédio. Sem um ambiente estimulante e desafiador, os membros podem perder o entusiasmo e se afastar das atividades físicas.

### 1.3 Objetivo geral

O objetivo deste projeto é desenvolver uma aplicação de gestão de academia que busque resolver o problema da falta de personalização, proporcionando aos clientes um programa de treino e orientação nutricional adaptado às suas necessidades individuais. Pretendemos revolucionar a experiência na academia, promovendo resultados mais eficazes e satisfação a longo prazo.

#### 1.3.1 Objetivos específicos

1. Desenvolver um algoritmo para avaliar as informações individuais dos usuários, considerando fatores como histórico médico, preferências alimentares e níveis de aptidão física, a fim de recomendar planos de treinamento personalizados que maximizem os resultados.

2. Criar uma plataforma intuitiva que permita aos usuários definirem suas metas, restrições e preferências, resultando em programas de exercícios e orientações nutricionais altamente customizados.

3. Desenvolver recursos de acompanhamento como status de progresso para permitir que os usuários observem seu crescimento ao longo do tempo, reforçando a motivação e a sensação de realização.

### 1.4 Justificativas

Este projeto é movido pela necessidade de superar as limitações dos métodos tradicionais das academias. A aplicação proposta não só resolve o problema comum dos clientes regulares, mas também fornece uma solução inovadora para melhorar a eficiência do treinamento e a motivação do usuário. Ao dar a cada membro acesso a um plano pessoal, o aplicativo pode aumentar muito o sucesso individual em busca do corpo ideal e de uma boa saúde. Em um mercado saturado onde as opções de treino variam, ser capaz de oferecer uma experiência única e atraente pode ser fundamental para atrair e reter membros. Além disso, estaremos contribuindo para o desenvolvimento da indústria do fitness ao adotar uma abordagem mais eficiente e fácil de usar, estimulando assim novas pessoas a aderirem ao estilo de vida saudável.

## 2. Participantes do processo

Participantes do processo:

Cliente: Indivíduos interessados ​​em fitness e saúde que desejam uma abordagem personalizada para atingir seus objetivos. Eles variam em idade, sexo e condicionamento físico, desde iniciantes até atletas experientes. Cada usuário final possui um perfil pessoal que inclui informações como objetivos, preferências alimentares e limitações físicas. 

Treinadores e Nutricionistas: Profissionais de saúde e fitness que atuam como professores e especialistas para usuários finais. Estes profissionais nos darão acesso a informações gerais e detalhadas que contribuirão para o nosso algoritmo criar planos de treinamento personalizados e orientações nutricionais, além de fornecer suporte contínuo e ajustes conforme necessário. 

Academia: A academia é uma parte importante do processo responsável pela gestão geral do sistema “WorkoutWiz”. Funcionários do local irão garantir o bom funcionamento da plataforma no ambiente retratado e fazer a recepção de novos membros que entraram na rotina saudável através da nossa aplicação. Embora não estejam diretamente envolvidos na interação diária com os clientes, são fundamentais para manter a qualidade do serviço e integrar totalmente o sistema com o local de treino.

## 3. Modelagem do processo de negócio

### 3.1. Análise da situação atual

Hoje em dia, a maioria das academias oferece programas de exercícios e orientações
nutricionais baseadas em abordagens gerais. Os treinadores se comunicam diretamente
com os membros, coletam informações básicas e preparam planos de treinamento padrão.
A comunicação é limitada e a personalização é mínima. Os membros acompanham o seu
progresso manualmente, o que leva à falta de motivação e perda de interesse ao longo do
tempo. As academias lutam para manter os sócios engajados e atender às suas
expectativas individuais. O nosso sistema resolveria tal situação promovendo uma
abordagem de rotina personalizada e eficaz, visando objetivos, preferências alimentares e
limitações físicas de cada usuário.

### 3.2. Descrição geral da proposta

“WorkoutWiz” sugere mudar o cenário atual. A aplicação oferece uma plataforma
abrangente que conecta usuários, dados nutricionais e análise das condições físicas de
forma inovadora. Os usuários finais têm acesso a uma interface de usuário intuitiva onde
podem inserir informações detalhadas sobre si mesmos, incluindo objetivos e preferências
alimentares. Com base nessas informações, algoritmos avaliam os perfis dos usuários e
criam planos de treinamento personalizados e otimizados para obter melhores resultados.
Os dados gerados pelo algoritmo se comunicam diretamente com os usuários e fornecem
orientação contínua e ajustam os planos com base no progresso e nas necessidades
individuais. Além disso, o programa oferece recursos de rastreamento que permitem aos
usuários acompanhar visualmente seu progresso ao longo do tempo. Isso aumenta a
motivação e a sensação de realização, o que melhora o engajamento. A oferta
“WorkoutWiz” está aprimorada das estratégias e objetivos das academias atuais, visando
proporcionar uma experiência mais personalizada e envolvente aos seus membros. O
programa oferece oportunidades significativas de desenvolvimento, maximizando os
resultados de saúde e condicionamento físico dos usuários. Ao introduzir tecnologias e
personalização, a nossa aplicação pode transformar a forma como as academias são
geridas e responder às necessidades individuais dos seus membros, aumentando a sua
eficiência e competitividade num mercado em constante evolução.

### 3.3. Modelagem dos processos

[PROCESSO 1 - Avaliação Inicial](processo-1-Avaliacao-Inicial.md "Detalhamento do Processo 1.")

[PROCESSO 2 - Plano de Treino](processo-2-Plano-de-Treino.md "Detalhamento do Processo 2.")

[PROCESSO 3 - Acompanhamento do Progresso](processo-3-Acompanhamento-do-Progresso.md "Detalhamento do Processo 3.")

[PROCESSO 4 - Planejamento de Treinos](processo-4-Planejamento-de-Treinos.md "Detalhamento do Processo 4.")

[PROCESSO 5 - Aprimoramento de Orientações Técnicas](processo-5-Aprimoramento-Orientacoes-Tecnicas.md "Detalhamento do Processo 5.")

[PROCESSO 6 - FeedBack](processo-6-Feedback.md "Detalhamento do Processo 6.")

## 4. Projeto da solução

O documento a seguir apresenta o detalhamento do projeto da solução. São apresentadas cinco seções que descrevem, respectivamente: diagrama de classes, diagrama de componentes, diagrama de entidade-relacionamento, tecnologias utilizadas e guias de estilo.

[Projeto da solução](solution-design.md "Detalhamento do Projeto da solução: classes, componentes, der, tecnologias e guias de estilo.")


## 5. Indicadores de desempenho

O documento a seguir apresenta os indicadores de desempenho dos processos.

[Indicadores de desempenho dos processos](performance-indicators.md)


## 6. Interface do sistema

A sessão a seguir apresenta a descrição do produto de software desenvolvido. 

[Documentação da interface do sistema](interface.md)

## 7. Testes

A sessão a seguir apresenta a descrição dos testes de unidade e testes de usabilidade realizados. 

[Testes do sistema](tests.md)

## 8. Conclusão

_Apresente aqui a conclusão do seu trabalho. Discussão dos resultados obtidos no trabalho, onde se verifica as observações pessoais de cada aluno. Poderá também apresentar sugestões de novas linhas de estudo._

# REFERÊNCIAS

_Como um projeto de software não requer revisão bibliográfica, a inclusão das referências não é obrigatória. No entanto, caso você deseje incluir referências relacionadas às tecnologias, padrões, ou metodologias que serão usadas no seu trabalho, relacione-as de acordo com a ABNT._

_Verifique no link abaixo como devem ser as referências no padrão ABNT:_

http://www.pucminas.br/imagedb/documento/DOC_DSC_NOME_ARQUI20160217102425.pdf


**[1.1]** - _ELMASRI, Ramez; NAVATHE, Sham. **Sistemas de banco de dados**. 7. ed. São Paulo: Pearson, c2019. E-book. ISBN 9788543025001._

**[1.2]** - _COPPIN, Ben. **Inteligência artificial**. Rio de Janeiro, RJ: LTC, c2010. E-book. ISBN 978-85-216-2936-8._

**[1.3]** - _CORMEN, Thomas H. et al. **Algoritmos: teoria e prática**. Rio de Janeiro, RJ: Elsevier, Campus, c2012. xvi, 926 p. ISBN 9788535236996._

**[1.4]** - _SUTHERLAND, Jeffrey Victor. **Scrum: a arte de fazer o dobro do trabalho na metade do tempo**. 2. ed. rev. São Paulo, SP: Leya, 2016. 236, [4] p. ISBN 9788544104514._

**[1.5]** - _RUSSELL, Stuart J.; NORVIG, Peter. **Inteligência artificial**. Rio de Janeiro: Elsevier, c2013. xxi, 988 p. ISBN 9788535237016._



# APÊNDICES


_Atualizar os links e adicionar novos links para que a estrutura do código esteja corretamente documentada._


## Apêndice A - Código fonte

[Código do front-end](../src/front) -- repositório do código do front-end

[Código do back-end](../src/back)  -- repositório do código do back-end


## Apêndice B - Apresentação final


[Slides da apresentação final](presentations/arquivo.pdf)


[Vídeo da apresentação final](video/arquivo.mp4)






