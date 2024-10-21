# Relación entre Entidades - PrograMobilAPI_S2_2024

Este proyecto implementa una API para gestionar información de usuarios, pacientes y registros médicos. A continuación, se detalla la **cardinalidad** y relaciones entre las entidades definidas.

---

## **1. Usuario - Rol** (Many-to-Many)
- Un **Usuario** puede tener múltiples **Roles**.
- Un **Rol** puede estar asignado a varios **Usuarios**.

**Relación en las entidades:**
- En `Usuario.java`:  
  ```java
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "usuario_roles",
      joinColumns = @JoinColumn(name = "usuario_id"),
      inverseJoinColumns = @JoinColumn(name = "rol_id"))
  private Set<Rol> roles = new HashSet<>();
  ```
- En `Rol.java`:  
  ```java
  @ManyToMany(mappedBy = "roles")
  private List<Usuario> users = new ArrayList<>();
  ```

---

## **2. Padre - PerfilPaciente** (One-to-One)
- Cada **Padre** tiene un único **PerfilPaciente** asociado.
- Cada **PerfilPaciente** pertenece exclusivamente a un **Padre**.

**Relación en las entidades:**
- En `Padre.java`:  
  ```java
  @OneToOne(mappedBy = "padre", cascade = CascadeType.ALL)
  private PerfilPaciente perfilPaciente;
  ```
- En `PerfilPaciente.java`:  
  ```java
  @OneToOne
  @JoinColumn(name = "padre_id", referencedColumnName = "padre_id")
  private Padre padre;
  ```

---

## **3. PerfilPaciente - DatosMedicos** (One-to-One)
- Un **PerfilPaciente** tiene un único registro de **DatosMedicos**.
- Los **DatosMedicos** pertenecen a un único **PerfilPaciente**.

**Relación en las entidades:**
- En `PerfilPaciente.java`:  
  ```java
  @OneToOne(mappedBy = "perfilPaciente", cascade = CascadeType.ALL)
  private DatosMedicos datosMedicos;
  ```
- En `DatosMedicos.java`:  
  ```java
  @OneToOne
  @JoinColumn(name = "perfil_id", referencedColumnName = "perfil_id")
  private PerfilPaciente perfilPaciente;
  ```

---

## **4. DatosMedicos - RegistroMedico** (One-to-Many)
- Un registro de **DatosMedicos** puede tener múltiples **RegistroMedico**.
- Cada **RegistroMedico** está vinculado a un solo registro de **DatosMedicos**.

**Relación en las entidades:**
- En `DatosMedicos.java`:  
  ```java
  @OneToMany(mappedBy = "datosMedicos", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<RegistroMedico> registros = new ArrayList<>();
  ```
- En `RegistroMedico.java`:  
  ```java
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "datos_medicos_id", nullable = false)
  private DatosMedicos datosMedicos;
  ```

---

## **5. PerfilPaciente - EsquemaVacunacion** (One-to-Many)
- Un **PerfilPaciente** puede tener múltiples registros de **EsquemaVacunacion**.
- Cada **EsquemaVacunacion** pertenece a un solo **PerfilPaciente**.

**Relación en las entidades:**
- En `PerfilPaciente.java`:  
  ```java
  @OneToMany(mappedBy = "perfilPaciente", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<EsquemaVacunacion> esquemaVacunacion = new ArrayList<>();
  ```
- En `EsquemaVacunacion.java`:  
  ```java
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "perfil_id", nullable = false)
  private PerfilPaciente perfilPaciente;
  ```

---

## **6. Vacuna - EsquemaVacunacion** (Many-to-One)
- Una **Vacuna** puede ser administrada varias veces a distintos pacientes.
- Cada **EsquemaVacunacion** está asociado a una única **Vacuna**.

**Relación en las entidades:**
- En `EsquemaVacunacion.java`:  
  ```java
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vacuna_id", nullable = false)
  private Vacuna vacuna;
  ```

---

## **Diagrama Resumido de Cardinalidad**

- **Usuario** ⇄ **Rol**: Many-to-Many  
- **Padre** ⇄ **PerfilPaciente**: One-to-One  
- **PerfilPaciente** ⇄ **DatosMedicos**: One-to-One  
- **DatosMedicos** ⇄ **RegistroMedico**: One-to-Many  
- **PerfilPaciente** ⇄ **EsquemaVacunacion**: One-to-Many  
- **Vacuna** ⇄ **EsquemaVacunacion**: Many-to-One  

---

## **Instrucciones para la Ejecución**

1. Clonar el repositorio:  
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd PrograMobilAPI_S2_2024
   ```

2. Configurar la base de datos en `application.properties` o `application.yml`.

3. Ejecutar la aplicación:  
   ```bash
   ./mvnw spring-boot:run
   ```

---

Con este diseño de entidades y su documentación de cAquí tienes un ejemplo de **README.md** explicando la **cardinalidad** de las entidades:

---

# Relación entre Entidades - PrograMobilAPI_S2_2024

Este proyecto implementa una API para gestionar información de usuarios, pacientes y registros médicos. A continuación, se detalla la **cardinalidad** y relaciones entre las entidades definidas.

---

## **1. Usuario - Rol** (Many-to-Many)
- Un **Usuario** puede tener múltiples **Roles**.
- Un **Rol** puede estar asignado a varios **Usuarios**.

**Relación en las entidades:**
- En `Usuario.java`:  
  ```java
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "usuario_roles",
      joinColumns = @JoinColumn(name = "usuario_id"),
      inverseJoinColumns = @JoinColumn(name = "rol_id"))
  private Set<Rol> roles = new HashSet<>();
  ```
- En `Rol.java`:  
  ```java
  @ManyToMany(mappedBy = "roles")
  private List<Usuario> users = new ArrayList<>();
  ```

---

## **2. Padre - PerfilPaciente** (One-to-One)
- Cada **Padre** tiene un único **PerfilPaciente** asociado.
- Cada **PerfilPaciente** pertenece exclusivamente a un **Padre**.

**Relación en las entidades:**
- En `Padre.java`:  
  ```java
  @OneToOne(mappedBy = "padre", cascade = CascadeType.ALL)
  private PerfilPaciente perfilPaciente;
  ```
- En `PerfilPaciente.java`:  
  ```java
  @OneToOne
  @JoinColumn(name = "padre_id", referencedColumnName = "padre_id")
  private Padre padre;
  ```

---

## **3. PerfilPaciente - DatosMedicos** (One-to-One)
- Un **PerfilPaciente** tiene un único registro de **DatosMedicos**.
- Los **DatosMedicos** pertenecen a un único **PerfilPaciente**.

**Relación en las entidades:**
- En `PerfilPaciente.java`:  
  ```java
  @OneToOne(mappedBy = "perfilPaciente", cascade = CascadeType.ALL)
  private DatosMedicos datosMedicos;
  ```
- En `DatosMedicos.java`:  
  ```java
  @OneToOne
  @JoinColumn(name = "perfil_id", referencedColumnName = "perfil_id")
  private PerfilPaciente perfilPaciente;
  ```

---

## **4. DatosMedicos - RegistroMedico** (One-to-Many)
- Un registro de **DatosMedicos** puede tener múltiples **RegistroMedico**.
- Cada **RegistroMedico** está vinculado a un solo registro de **DatosMedicos**.

**Relación en las entidades:**
- En `DatosMedicos.java`:  
  ```java
  @OneToMany(mappedBy = "datosMedicos", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<RegistroMedico> registros = new ArrayList<>();
  ```
- En `RegistroMedico.java`:  
  ```java
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "datos_medicos_id", nullable = false)
  private DatosMedicos datosMedicos;
  ```

---

## **5. PerfilPaciente - EsquemaVacunacion** (One-to-Many)
- Un **PerfilPaciente** puede tener múltiples registros de **EsquemaVacunacion**.
- Cada **EsquemaVacunacion** pertenece a un solo **PerfilPaciente**.

**Relación en las entidades:**
- En `PerfilPaciente.java`:  
  ```java
  @OneToMany(mappedBy = "perfilPaciente", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<EsquemaVacunacion> esquemaVacunacion = new ArrayList<>();
  ```
- En `EsquemaVacunacion.java`:  
  ```java
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "perfil_id", nullable = false)
  private PerfilPaciente perfilPaciente;
  ```

---

## **6. Vacuna - EsquemaVacunacion** (Many-to-One)
- Una **Vacuna** puede ser administrada varias veces a distintos pacientes.
- Cada **EsquemaVacunacion** está asociado a una única **Vacuna**.

**Relación en las entidades:**
- En `EsquemaVacunacion.java`:  
  ```java
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vacuna_id", nullable = false)
  private Vacuna vacuna;
  ```

---

## **Diagrama Resumido de Cardinalidad**

- **Usuario** ⇄ **Rol**: Many-to-Many  
- **Padre** ⇄ **PerfilPaciente**: One-to-One  
- **PerfilPaciente** ⇄ **DatosMedicos**: One-to-One  
- **DatosMedicos** ⇄ **RegistroMedico**: One-to-Many  
- **PerfilPaciente** ⇄ **EsquemaVacunacion**: One-to-Many  
- **Vacuna** ⇄ **EsquemaVacunacion**: Many-to-One  

---

## **Instrucciones para la Ejecución**

1. Clonar el repositorio:  
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd PrograMobilAPI_S2_2024
   ```

2. Configurar la base de datos en `application.properties` o `application.yml`.

3. Ejecutar la aplicación:  
   ```bash
   ./mvnw spring-boot:run
   ```
