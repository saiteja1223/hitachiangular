import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UpdateComponent } from './update/update.component';
import { ShowComponent } from './show/show.component';

const routes: Routes = [
  {path:'',redirectTo:'/show',pathMatch:'full'},
  {path:'up/:id',component:UpdateComponent},
  {path:'show',component:ShowComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
