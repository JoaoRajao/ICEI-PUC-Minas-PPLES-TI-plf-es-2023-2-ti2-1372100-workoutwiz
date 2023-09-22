### 3.3.6 Processo 6 – *FeedBack dos profissionais :*

Descrição: Este processo visa aprimorar a motivação dos usuários por meio de um sistema de feedbacks, promover a interação entre os usuários e criar um senso de comunidade através de recursos de compartilhamento e espaços de discussão onde possam deixar uma avaliação de algumas interações que tiveram com os profissionais. 

![PROCESSO 6](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2023-2-ti2-1372100-workoutwiz/blob/master/docs/images/absence-request%20(2).png)


#### Detalhamento das atividades

  Atividade 1- Escrever um comentario para a comunidade ou profissional .
  
  Atividade 2 - Oferecer recursos de compartilhamento para que os usuários possam mostrar suas experiencias.
  
  Atividade 3 - Criar um fórum ou espaço para a comunidade onde os usuários possam trocar dicas, experiências e motivação.

Os tipos de dados a serem utilizados são:

* **Área de texto** - campo texto de múltiplas linhas
* **Caixa de texto** - campo texto de uma linha
* **Número** - campo numérico
* **Data** - campo do tipo data (dd-mm-aaaa)
* **Hora** - campo do tipo hora (hh:mm:ss)
* **Data e Hora** - campo do tipo data e hora (dd-mm-aaaa, hh:mm:ss)
* **Imagem** - campo - contendo uma imagem
* **Seleção única** - campo com várias opções de valores que são mutuamente exclusivos (tradicional radio button ou combobox)
* **Seleção múltipla** - campo com várias opções que podem ser selecionadas mutuamente (tradicional checkbox ou listbox)
* **Arquivo** - campo de upload de documento
* **Link** - campo que armazena uma URL
* **Tabela** - campo formado por uma matriz de valores

** Escrever um comentario**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
| ***Exemplo:***  |                  |                |                   |
| Area de texto          | Área de texto   |  |                |
| Escolher o publico        | radio button   | |     Profissional      |
| Enviar        | submit   | |          |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
| ***Exemplo:***       |                                |                   |
|  Enviar               | Fim da atividade 1              | default           |



**Recursos de compartilhamento**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
|  Escolher uma rede social   |    Link       |                |                   |




| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
|  Escolher uma rede social   |    Fim da atividade 2    |                   |




** Criar um fórum**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
|    Criar comunidade   |    Button              |                |                   |
|   Nome       |       Caixa de texto       |                |                   |
|  Confirmar    |       button       |                |                   |




| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
|          Confirmar         | Atividade 1                                |                   |
