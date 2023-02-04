# Challenge ONE - Java - Back-end - HotelAluraOne
![apresentação](https://user-images.githubusercontent.com/86839388/216786301-7f8d6de6-115e-48fe-9344-29d41d2b3033.gif)

📑 Este projeto desenvolvido em Java tem como objetivo simular um sistema de reservas e cadastro de hóspedes para hotéis. Além disso, foram implementados tratamentos de erro para garantir a eficiência e segurança do sistema.

## Sobre o projeto HotelAluraOne:

Este projeto foi construído usando a linguagem de programação Java com o objetivo de aplicar os conhecimentos adquiridos na One Oracle Next Education. O projeto tem como finalidade incentivar a criatividade dos desenvolvedores na criação de um sistema de gerenciamento de reservas e cadastro de hóspedes eficiente e inovador.

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/antonysf/Challenge-ONE-Java-Back-end-HotelAluraOne/blob/main/LICENSE) 


## 🖥 Tecnologias e dependências utilizadas no projeto:

✅ Java

✅ Eclipse

✅ MySQL

✅ Biblioteca JCalendar

✅ Plugin WindowBuilder.


### Para compatibilidade, é recomendado utilizar o Java na versão 8 ou superior. É aconselhável o uso do editor Eclipse para compatibilidade da interface gráfica.



### 🎨 A interface gráfica contém dois métodos importantes:

✔️ setResizable(false): define o tamanho da janela, impedindo sua maximização através do parâmetro false;

✔️ setLocationRelativeTo(null): define a localização da janela, mantendo-a centralizada na tela através do parâmetro null.

⚠️ Neste desafio, foi implementado algumas modificações para melhorias do projeto, pode ser adicionado outras funcionalidade novas e modificar ainda mais a interface gráfica.



### 📁 A base do projeto já está pronta e inclui as seguintes pastas:

 ✔️src/views: contém toda a interface gráfica das telas necessárias para o desenvolvimento do programa;
 
 ✔️src/imagens: src/imagens: contém imagens que podem ser utilizadas no projeto. Algumas modificações foram realizadas para atender às necessidades do projeto e adicionei comentários para uma melhor compreensão do codigo.

🔗 ➡️ O link para a base do projeto você encontra em: https://github.com/Alquimistas-AluraLatam/PT-hotel-alura



### Existem duas maneiras de importar o projeto para o Eclipse:

🔸 Clique em "File" no menu na parte superior do editor, escolha a opção "Open Projects from File System", clique em "Directory" e localize o diretório do projeto clonado ou extraído em seu computador. Em seguida, clique em "Finish" para concluir a importação.

🔸 Clique em "File", escolha a opção "Import" ou, no "Project Explorer", clique com o botão direito do mouse em um campo vazio e escolha "Import". Clique em "Existing Projects Into Workspace" e "Next", depois clique em "Browse" e busque o projeto no diretório local.

⚠️ Para obter mais informações sobre a importação do projeto, consulte o link da base do projeto.



### Dependencias utilizadas e como importar

🔷 Para importar as dependências, basta seguir os seguintes passos:

🔹 No Eclipse, acesse a aba Project.

🔹 Clique com o botão direito em cima do nome do seu projeto.

🔹 Selecione a opção Build Path e em seguida, selecione a opção Configure Build Path.

🔹 Clique na aba Libraries e em seguida, clique no botão Add JARs.

🔹 Busque as bibliotecas necessárias na pasta "libs" do projeto e adicione-as.

🔹 Clique em Apply and Close para finalizar a importação das dependências.


👀 Para corrigir o erro de biblioteca ausente no projeto, siga os seguintes passos:

⚠️ - No Eclipse, acesse a seção de "Libraries" na aba de configurações do projeto.

⚠️ - Selecione a guia "Classpath" e localize o arquivo da biblioteca JCalendar.

⚠️ - Clique na opção "Remove" para remover o arquivo ausente e em seguida clique em "Apply and Close" para salvar as alterações e fechar a janela de configurações.


✅ jcalendar-1.4

✅ c3p0-0.9.0

✅ c3p0-0.9.5.4

✅ commons-configuration2-2.1.1-javadoc

✅ jcalendar-1.4

✅ jgoodies-common-1.2.0

✅ jgoodies-looks-2.4.1

✅ junit-4.6

✅ mchange-commons-java-0.2.11

✅ mchange-commons-java-0.2.16

✅ mysql-connector-java-8.0.22

✅ mysql-connector-java-8.0.32


### Banco de Dados


✏️ Como importar o MySql Connector no projeto?


🔸 Para importar o MySql Connector no seu projeto, você precisa clicar com o botão direito do mouse no nome do projeto, selecionar "Build Path" > "Configure Build Path" > "Libraries" > "Add External JARs". Para encontrar o arquivo .jar do MySql Connector, vá até a pasta "Arquivos de Programas (x86)" em seu disco rígido. Em seguida, vá até a pasta do MySQL, Connector J 8.0, e procura pelo arquivo "MySQL Connector Java".



✨ Modelagem de Tabelas

➡️ Nesse projeto, foram criadas duas tabelas: Reservas e Hóspedes. A tabela de hóspedes contém uma chave estrangeira (foreign key) para a tabela de reservas, identificada por "idReserva".


✅ Tabela reservas

🔹 id: int;

🔹 DataEntrada: DATE;

🔹 DataSaida: DATE;

🔹 Valor: int;

🔹 FormaPagamento: Varchar(45)


✅ Tabela de hospedes

🔹 id:int;

🔹 Nome: Varchar(45)

🔹 Sobrenome: Varchar(45)

🔹 DataNascimento: DATE;

🔹 Nacionalidade: Varchar(45);

🔹 Telefone: Varchar(15);

🔹 idReserva: int



🎨 Instalação do WindowBuilder no Eclipse


🔹 Vá até a aba Help no menu do Eclipse.

🔹 Selecione a opção Eclipse Marketplace.

🔹 Na barra de pesquisa, digite "window builder" e clique em Go.

🔹 Selecione a primeira opção na lista de resultados da busca.

🔹 Clique em Install para instalar o plugin.

🔹 Confirme a instalação ao clicar em Confirm.

🔹 Aceite os Termos de Uso para continuar a instalação.

🔹 Conclua a instalação clicando em Finish.


## Autor
Antônio dos Santos Figueiredo

🔗 https://www.linkedin.com/in/antonio-figueiredo-dev/


