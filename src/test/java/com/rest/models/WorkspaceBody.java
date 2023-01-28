package com.rest.models;

public class WorkspaceBody {
    private Workspace workspace;
    public Workspace getWorkspace() {
        return this.workspace;
    }

    public WorkspaceBody(){}
    public WorkspaceBody(Workspace workspace) {
        this.workspace = new Workspace(workspace);
    }
}
