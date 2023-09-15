### 3.3.3 Processo 3 – Acompanhamento do Progresso e Desempenho:



Nessa etapa, os usuários podem registrar os detalhes de suas atividades e os resultados alcançados em cada exercício. Esses dados, que incluem informações como pesos utilizados, distâncias percorridas e tempos alcançados, são armazenados para posterior análise. Esses dados são usados ​​para criar infográficos e relatórios em vídeo que permitem aos usuários acompanhar especificamente seu progresso ao longo do tempo, fornecendo motivação e orientação contínua.



![PROCESSO 3](images/diagrama3(2).png "Modelo BPMN do Processo 3.")

#### Detalhamento das atividades

* **Atividade 1 - Registro de Atividades e Resultados**: Permitir que os usuários registrem suas atividades e resultados de cada treino.
* **Atividade 2 - Armazenamento de Informações**: Armazenar informações como pesos levantados, distâncias percorridas e tempos alcançados.
* **Atividade 3 - Gráfico e Relatório do Progresso**: Gerar gráficos e relatórios para mostrar visualmente o progresso ao longo do tempo.


Os tipos de dados a serem utilizados são:

* **Área de texto** - campo texto de múltiplas linhas
* **Caixa de texto** - campo texto de uma linha
* **Número** - campo numérico
* **Data** - campo do tipo data (dd-mm-aaaa)
* **Hora** - campo do tipo hora (hh:mm:ss)
* **Data e Hora** - campo do tipo data e hora (dd-mm-aaaa, hh:mm:ss)
* **Imagem** - campo contendo uma imagem
* **Seleção única** - campo com várias opções de valores que são mutuamente exclusivos (tradicional radio button ou combobox)
* **Seleção múltipla** - campo com várias opções que podem ser selecionadas mutuamente (tradicional checkbox ou listbox)
* **Arquivo** - campo de upload de documento
* **Link** - campo que armazena uma URL
* **Tabela** - campo formado por uma matriz de valores

**Registro de Atividades e Resultados**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Registro de Atividades | Área de texto | Mínimo de 20 caracteres | Descreva as suas atividades |
| Registro de Resultados | Área de texto | Mínimo de 20 caracteres | Descreva os seus resultados |


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Salvar Registro | Salva os registros feitos pelo usuário e os adiciona ao seu perfil | --- |


**Armazenamento de Informações**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Pesos levantados | Área de texto | Aceita apenas números | Informe os pesos levantados |
| Distâncias percorridas   | Área de texto | Aceita apenas números | Informe as distâncias percorridas |
| Tempos alcançados | Área de texto | Aceita apenas números | Informe os tempos alcançados |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Cadastrar Informações| Atualiza as informações do plano de treino | --- |


**Gráfico e Relatório do Progresso**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Gráfico | Imagem | --- | --- |
| Relatório | Imagem | --- | --- |


| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Visualizar Relatório | Exibe os relatórios mostrando o progresso do usuário | --- |
