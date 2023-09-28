### 3.3.5 Processo 5 – Aprimoramento de Orientações Técnicas

Descrição: Este processo visa aprimorar a qualidade das orientações técnicas e feedback fornecidos aos usuários durante o treinamento, incorporando vídeos instrucionais, feedback em tempo real e dicas de segurança para melhorar a eficácia dos movimentos e prevenir lesões.

![diagrama5update](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2023-2-ti2-1372100-workoutwiz/assets/130581220/afcc8f69-9af0-4a75-9f8e-bf5234b9f5b0)



#### Detalhamento das atividades

**Atividade 1 - Mídias demonstrativas**:  Incluir vídeos e imagens demonstrando a forma correta de execução de cada exercício.

**Atividade 2 - Feedback da execução dos exercícios:** Fornecer dicas para melhorar a eficácia dos movimentos e evitar lesões.


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

**Mídias demonstrativas**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Exibir mídia]    | [Fotos e vídeos]   |                |[Veja a execução certa] |
|                 |                  |                |                   |


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
| ***Exemplo:***       |                                |                   |
| entrar               | Fim do Processo 1              | default           |
| cadastrar            | Início do proceso de cadastro  |                   |


**Nome da atividade 2**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
|                 |                  |                |                   |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
|                      |                                |                   |
