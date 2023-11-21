### 3.3.6 Processo 6 – *FeedBack:*

Descrição: Este processo visa aprimorar a motivação dos usuários por meio de um sistema de feedbacks, promover a interação entre os usuários e criar um senso de comunidade através de recursos de compartilhamento e espaços de discussão onde possam deixar uma avaliação de algumas interações que tiveram com os profissionais. 

![PROCESSO 6](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2023-2-ti2-1372100-workoutwiz/blob/master/docs/images/absence-request%20(2).png)


#### Detalhamento das atividades

  Atividade 1- Escrever um comentario.
  
  Atividade 2 - Oferecer recursos de compartilhamento para que os usuários possam mostrar suas experiencias.
  
  Atividade 3 - Criar um fórum ou espaço para a comunidade onde os usuários possam trocar dicas, experiências e motivação.


**Comentário / feedback**


| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Area de texto          | Área de texto   | minimo de 10 caracteres |                |
| Escolher o publico        | Seleção única   | --|     Profissional      |


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
|  Enviar               | Fim da atividade 1              | default           |



**Recursos de compartilhamento**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
|  Escolher uma rede social   |    Link       |                |                   |




| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
|  Escolher uma rede social   |    Fim da atividade 2    |                   |




**Criar um forum**
| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
|   Nome       |       Caixa de texto       | minimo de 10 caracteres               |        --           |




| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
|    Criar comunidade   |  Continua a atividade             |        default        |                   
|          Confirmar         | Atividade 1                                |     default              |
