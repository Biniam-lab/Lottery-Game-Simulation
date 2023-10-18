import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule} from '@angular/router';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { LottomaxComponent } from './components/lottomax/lottomax.component';
import { Lotto649Component } from './components/lotto649/lotto649.component';
import { GridComponent } from './components/grid/grid.component';
import { LotteryService } from './services/lottery.service';

const routes: Routes = [
  {path:'lottomax', component:LottomaxComponent},
  {path:'lotto649', component:Lotto649Component}
];

@NgModule({
  declarations: [
    AppComponent,
    LottomaxComponent,
    Lotto649Component,
    GridComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [ LotteryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
