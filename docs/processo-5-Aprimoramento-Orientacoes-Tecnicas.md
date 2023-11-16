### 3.3.5 Processo 5 – Aprimoramento de Orientações Técnicas

Descrição: Este processo visa aprimorar a qualidade das orientações técnicas e feedback fornecidos aos usuários durante o treinamento, incorporando vídeos instrucionais, feedback em tempo real e dicas de segurança para melhorar a eficácia dos movimentos e prevenir lesões.

![new-bpmn-diagram (2)](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2023-2-ti2-1372100-workoutwiz/assets/130581220/5eb37591-00ce-4dbd-933a-500728acde2b)



#### Detalhamento das atividades

**Atividade 1 - Mídias demonstrativas**:  Incluir vídeos e imagens demonstrando a forma correta de execução de cada exercício.

**Atividade 2 - Feedback da execução dos exercícios:** Fornecer dicas para melhorar a eficácia dos movimentos e evitar lesões.

**Atividade 3 - Dicas de Segurança:** Fornecer dicas para garantir a segurança do usuário ao realizar os exercícios.




**Mídias demonstrativas**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Execuções dos movimentos    | Arquivos de mídia   |---               |Confira a melhor execução para esse exercício|
| Descrição da execução                |Área de texto                  |Aceita apenas texto                |Explicação do movimento                  |


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Apresentar mídias e descrição para cada exercício| Início do processo de orientações  | -- |

**Dicas de Segurança**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Dicas de segurança               |Área de texto                  |---               |Algumas dicas para uma execução mais segura                  |


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Apresentar dicas para segurnça do usuário em forma de campo de texto| Fim do processo de orientações  | -- |


**Feedback da execução dos exercícios**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Fornecer feedback | Área de texto  |Aceita apenas texto             |Informe o feedback da execução                 |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Editar e salvar feedback | --- | -- |
