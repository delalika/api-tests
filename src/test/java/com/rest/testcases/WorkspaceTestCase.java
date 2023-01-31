package com.rest.testcases;

import com.rest.controllers.WorkspaceController;
import com.rest.models.Workspace;
import com.rest.models.WorkspaceBody;
import com.rest.utils.JacksonUtils;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class WorkspaceTestCase {
    public WorkspaceController workspaceController = new WorkspaceController();
    public JacksonUtils jacksonUtils = new JacksonUtils();
    @Test
    public void test(){

        Workspace workspace = new Workspace(
                "New Workspace",
                "personal",
                "",
                "personal"
                );
        String newName = "New Workspace Test";
        WorkspaceBody workspaceBody = new WorkspaceBody(workspace);
        jacksonUtils.init();
        String workspaceJson = jacksonUtils.toJson(workspaceBody);
        String newWorkspaceJson = workspaceController.createWorkspace(workspaceJson, 200);

        WorkspaceBody newWorkspaceBody = jacksonUtils.fromJson(newWorkspaceJson, WorkspaceBody.class);
        String newWorkspaceId = newWorkspaceBody
                .getWorkspace()
                .getId();
        WorkspaceBody createdWorkspaceBody = getData(newWorkspaceJson);
        Workspace workspaceData = createdWorkspaceBody.getWorkspace();
        compareWorkspaceData(workspace, workspaceData);

        createdWorkspaceBody.getWorkspace().setName(newName);
        String updatedWorkspace = jacksonUtils.toJson(createdWorkspaceBody);
        String updatedWorkspaceJson = workspaceController.updateWorkspace(updatedWorkspace, newWorkspaceId, 200);
        Workspace updatedWorkspaceData = getData(updatedWorkspaceJson).getWorkspace();
        compareWorkspaceData(workspaceData, updatedWorkspaceData);

        workspaceController.deleteWorkspace(newWorkspaceId, 200);

    }

    private void compareWorkspaceData(Workspace workspace, Workspace newWorkspace){
        assertEquals(workspace.getName(), newWorkspace.getName());
        assertEquals(workspace.getType(), newWorkspace.getType());
        assertEquals(workspace.getDescription(), newWorkspace.getDescription());
        assertEquals(workspace.getVisibility(), newWorkspace.getVisibility());
    }

    private WorkspaceBody getData(String workspaceJson){
        WorkspaceBody workspaceBody = jacksonUtils.fromJson(workspaceJson, WorkspaceBody.class);
        String workspaceId = workspaceBody
                .getWorkspace()
                .getId();
        String workspaceBodyJson = workspaceController.getWorkspace(workspaceId, 200);
        return jacksonUtils.fromJson(workspaceBodyJson, WorkspaceBody.class);
    }
}
