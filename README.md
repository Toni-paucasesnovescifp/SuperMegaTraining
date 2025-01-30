# SuperMegaTraining

<p align="center"><b>RECURSOS</p></b>

¿cómo  añadir un colaborador en Github?  (utilizado para añadir al profesor de la asignatura como colaborador)
https://docs.github.com/es/account-and-profile/setting-up-and-managing-your-personal-account-on-github/managing-access-to-your-personal-repositories/inviting-collaborators-to-a-personal-repository

Consulta foro de clase sobre los sketches y edición fichero Readme.md
https://fpadistancia.caib.es/mod/forum/discuss.php?d=73378#p166879

<p align="center"><b>SKETCHES</p></b>

![foto1 (paginas que contiene)](https://github.com/user-attachments/assets/8ae68652-b16c-4730-97a7-e64c46bf82ae)

![foto 2 (continuacion foto 1)](https://github.com/user-attachments/assets/72c99419-cdd4-48a2-9d42-1d0b876842d3)

![foto 3 (esquema secuencias)](https://github.com/user-attachments/assets/86ab52c5-6508-4bac-b3dc-54552e6bff87)



<p align="center"><b>______________</p></b>
<p align="center"><b>USER EXPERIENCE</p></b>

Seguint la pràctica nº 4 del Mòdul de Desenvolupament d'Interfícies (data entrega  30-01-2025), S'han inclòs molts d'elements per millorar la usabilitat a l'aplicació i, per tant, proporcionar una millor experiència a l'usuari.

- **Look and Feel** -  s'ha utilitzat un de la col.lecició https://www.jtattoo.de/ , concretament el **Bernstein**.  És un acabat modern i juvenil basat en el color groc, que és un color càlid i alegre. A pesar de amb Berenstein tenir ja un joc de colors complet establert per tota l'aplicació, amb la finalitat de practicar i poder arribar a la màxima personalització, també s'ha definit el color "230, 240, 255", un color blau clar, per alguns components  (JButton, JLabel, ToolTip, i algun altre no massa utilitzat a l'aplicació).
![image](https://github.com/user-attachments/assets/58d5532b-8019-40fe-a0cc-448585225b8f)

  

- **Iconos i altres elements visuals** - A fi de millorar la usabilitat, s'han utilitzat uns elements visuals:
    - el logo de SuperMegaTraining està present en tot moment.
    - es mostra la foto de l'usuari que entrena amb l'instructor (ho agafa de la base de dades d'usuaris)
    - gairebé tots els botons (JButton) i també algunes etiquetes (JLabel) apart de texte , duen incorporat un petit "icon".
    - els missatges d'avís o informatius, duen incorporat o bé un petita imatge/icon o bé algun dels símbols que duu de sèrie el component utilitzat.
![image](https://github.com/user-attachments/assets/1b0ba39c-34a1-48d5-8ebe-cd57ae61ad17)
![image](https://github.com/user-attachments/assets/e53b9be7-44e2-4d32-8f13-931d92059d81)

      
 - **Font legible i intel.ligible** - S'han definit dues fons amb l'objectiu que facin l'aplicació atractiva i llegible. Són una tipologia de lletra molt clara i actual. Cada una d'elles,  s'han associat amb uns components concrets:
    - Open Sans Semi Bold, de tamany 14  (JLabel, JTableHeader, JButton, JTextField, JSpinner, JTextArea, JCombobox, JMenu i ToolTip)
    - Consolas, de tamany 14   (JTable i JList)
 
- **Col.locació dels components de manera organitzada i atractiva** - Els components estan disposats pensant amb l'ordre lògic d'utilització, facilitat d'ús (totes les opcions són totalment intuitives) i, a la vegada, cercant en tot moment l'atractiu de la interfície. Per exemple, en una mateixa pantalla veim els workouts i just a la dreta els exercicis de què es compon. O en el cas d'afegir un workout, no apareixen els components per afegir exercicis, fins que no s'hagi primer donat d'alta el workout.

- **Layout: MigLayout** S'ha utilitzat pràcticament a tota l'aplicació del MigLayout i per tots els components conteniddors (bàsicament JPanels i el JFrame principal)  el MigLayout. Aquest gestor de diseny de codi obert  permet una col.locació dels components amb molta flexibilitat, l'alineació i coordinació d'uns elements amb els altres, simplicitat i fàcil manteniment. S'utilitza molt amb aquest Layout la posició relativa (un davall l'altre, o al costat de l'altre, o a x distància de l'altre, o a certa distància del borde...). Alta potència pel cas de components que s'adapten al tamany del seu contenidor.   A totes les pantalles de l'aplicació (excepte el JDialog de LogIn) està present aquest Layout i permet poder fer la finestre més grossa o més petita (segons el dispositiu utilitzat, etc.) amb cert grau d'adaptació del seus components.
A la pantalla de l'exemple seu veu la mateixa pantalla amb dos tamanys distints de pantalla. Se veu, per exemple, com hi ha uns botons que són flexibles segons l'ample de la pantalla i altres que no han modificat el tamany a pesar d'haver canviat el tamany de la pantalla.
![image](https://github.com/user-attachments/assets/43eab4d4-6053-4949-97d2-a077ae7d6ed6)
![image](https://github.com/user-attachments/assets/be1c3cfc-bc95-433b-b986-e6c3daa049a6)

- **Gestió d'errors i excepcions** . S'ha treballat tant amb validacions prèvies, que ja no permeten fer el procés si la validació no ha complit la condició necessària i també casos en que hi ha excepcions. Exemples:
    - al JDialog del LogIn quan anam a fer la validació del Login si falla la base de dades ( per exemple, no hi ha internet o la cadena de conexió no és vàlida) surt un missatge per pantalla a l'usuari que conté un missatge personalitzat i també l'excepció que dona al sistema.  Això és una Excepció.
    - a la pantalla de donar d'alta workouts, no ens ho permet fer si no s'ha introduit la data. Això és una validació prèvia que atura el procés d'alta.
    - Si anam a el.liminar un workout que té exercicis assignats, se fa una validació prèvia , que ens avisa que primer s'han d'el.liminar els exercicis que conté.
    - Si anam a el.liminar un exercici que conté dades relacionades a altres taules, l'aplicació  no contempla la possibilitat i salta una excepció.
 
  ![image](https://github.com/user-attachments/assets/76fb982e-1f9e-4704-aecc-00169ba2d740)
  ![image](https://github.com/user-attachments/assets/9fc49e85-bfb4-440b-a666-2fa99f7543d0)
  ![image](https://github.com/user-attachments/assets/75f4d92a-4307-45c2-a48e-2bcbb5132653)
  ![image](https://github.com/user-attachments/assets/b49e1947-18bf-4914-8b88-ef85d803c15e)


  - **Altres prestacions per millorar la usabilidad** Podríem




  
