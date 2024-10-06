sequenceDiagram
    participant Usuario as Usuario
    participant Servidor
    Usuario->>Servidor: Solicitar datos
    Servidor-->>Usuario: Enviar datos
    Usuario->>Servidor: Confirmar recepción
    Servidor-->>Usuario: Confirmación recibida
    style Usuario fill:#FFCCCC,stroke:#333,stroke-width:2px,stroke-dasharray: 5 5
