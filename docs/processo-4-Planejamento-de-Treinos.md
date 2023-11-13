### 3.3.4 Processo 4 – * Planejamento de Treinos:*

Descrição: Este processo visa melhorar a experiência dos usuários ao enviar lembretes de treinos agendados, oferecer opções de planejamento flexíveis e permitir ajustes de horários de acordo com a disponibilidade individual.

![PROCESSO 4](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2023-2-ti2-1372100-workoutwiz/blob/master/docs/images/absence-request.png)


#### Detalhamento das atividades

Atividade 1-Enviar notificações para lembrar os usuários sobre os treinos agendados: O aplicativo enviará notificações personalizadas para lembrar os usuários de seus treinos agendados.

Atividade 2-Oferecer a opção de criar um cronograma semanal ou mensal de treinamentos: Os usuários podem criar um plano de treinamento personalizado escolhendo exercícios, dias da semana e duração. 

Atividade 3-Permitir que os usuários ajustem os horários de treino com base em sua disponibilidade: Os usuários têm a flexibilidade de ajustar os horários de treino sempre que necessário. Se a disponibilidade mudar, eles podem reorganizar seus treinos sem problemas.



**-Enviar notificações**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Input mensagem ativada] | [Seleção única]  |                |                   |



| **Comandos**         |  **Destino**                   | **Tipo** |
| ---             | ---              | ---            | 
| Ativar notificação              | Professor recebe a ficha       | default           |



**Criar um cronograma**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Escolher semanal/mensal |Seleção única |      --          |     semanal              |
| Adicionar exercicios | Seleção múltipla  |         --       |                   |
| Definir dias/semanas  |Data                  |       --         |                   |



| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
|  Confirmar |   O aluno recebe o cronograma                       |   default                |
| Adicionar  cronograma | Professor   | (default/cancel/  ) |

**Ajustar horários**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Editar data |Data |                |      somente datas          |default





| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Editar cronograma|  Continua a atividade  |    default            |                   
|     Confirmar                  |    final do processo                         |     default              |
