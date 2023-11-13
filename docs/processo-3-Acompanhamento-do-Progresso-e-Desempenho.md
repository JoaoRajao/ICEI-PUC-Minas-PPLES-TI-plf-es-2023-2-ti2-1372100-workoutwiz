### 3.3.3 Processo 3 – Acompanhamento do Progresso:



Nessa etapa, os usuários podem registrar os detalhes de suas atividades e os resultados alcançados em cada exercício. Esses dados, que incluem informações como pesos utilizados, distâncias percorridas e tempos alcançados, são armazenados para posterior análise. Esses dados são usados ​​para criar infográficos e relatórios em vídeo que permitem aos usuários acompanhar especificamente seu progresso ao longo do tempo, fornecendo motivação e orientação contínua.



![PROCESSO 3](images/diagrama3(3).png "Modelo BPMN do Processo 3.")

#### Detalhamento das atividades

* **Atividade 1 - Registro de Atividades e Resultados**: Permitir que os usuários registrem suas atividades e resultados de cada treino.
* **Atividade 2 - Gráfico e Relatório do Progresso**: Gerar gráficos e relatórios para mostrar visualmente o progresso ao longo do tempo.
* **Atividade 3 - Realizar Novo Planejamento**: Realiza um novo plano de treino caso as metas de progresso estabelecidas não sejam atingidas.

**Registro de Atividades e Resultados**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Pesos levantados | Área de texto | Aceita apenas números | Informe os pesos levantados |
| Distâncias percorridas   | Área de texto | Aceita apenas números | Informe as distâncias percorridas |
| Tempos alcançados | Área de texto | Aceita apenas números | Informe os tempos alcançados |


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Salvar Registro | Salva os registros feitos pelo usuário e os adiciona ao seu perfil | --- |


**Gráfico e Relatório do Progresso**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Gráfico | Imagem | --- | --- |
| Relatório   | Imagem | --- | --- |


| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Visualizar Progressão | Atualiza as informações da progressão | --- |


**Realizar Novo Planejamento**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Selecione os Exercícios que Deseja Melhorar a Progressão | Seleção múltipla | --- | Escolha os exercícios que deseja melhorar a progressão |
| Disponibilidade de Tempo | Data e Hora | Aceita apenas números | Escolha sua disponibilidade |
| Preferências de Treino | Seleção múltipla | --- | Escolha os exercícios que deseja fazer para aprimorar sua progressão |


| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Cadastrar Novo Plano de Treino | Atualiza o plano de treino | --- |
